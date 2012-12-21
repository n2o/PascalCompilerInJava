/**************************************************************************
 * Created by Christian Meter on 21st December 2012                       *
 *                                                                        *
 * Mainprogram for the StupsCompiler project                              *
 **************************************************************************
 * Usage: > java StupsCompiler -compile <Filename.pas>                    *
 **************************************************************************
 * ToDo:                                                                  *
 *  - Catch uninitialized variables                                       *
 *************************************************************************/

import com.sun.tools.corba.se.idl.IncludeGen;
import lexer.Lexer;
import lexer.LexerException;
import node.Start;
import parser.Parser;
import parser.ParserException;

import java.io.*;

public class StupsCompiler {

	public static void main(String[] args) throws LexerException, IOException, ParserException {
        String input = "";
        String fileName = args[1];
        if (args.length < 2) {  // catch valid number of arguments
            System.out.println("# Error: Not enough arguments.\n# Usage: > java StupsCompiler -argument <Filename.pas>\n# Valid arguments are: compile, liveness.");
            System.exit(1);
        }
        if (!args[1].endsWith(".pas")) {    // catch valid file extension
            System.out.println("# Error: Valid file extension is only '.pas'.");
            System.exit(1);
        }
        try {
            if (args[0].equals("-compile")) {       // Compile section
                String zeile;
                FileReader fr = new FileReader(fileName);
                BufferedReader br = new BufferedReader(fr);

                zeile = br.readLine();
                while (zeile != null) {
                    input += zeile+"\n";
                    zeile = br.readLine();
                }
                br.close();
                parse(input, fileName.substring(0, fileName.lastIndexOf('.')));

            } else if (args[0].equals("-liveness")) {
                // Write something about liveness...
            } else {
                System.out.println("# Error: Wrong usage of StupsCompiler.\n# Usage: > java StupsCompiler -compile <Filename.pas>");
            }
        } catch (FileNotFoundException e) {
            System.out.println("# Error: File '" + fileName + "' not found. Please enter correct filename.");
        } catch (ParserException e) {
            System.out.println("# Error in "+fileName+": "+e.getMessage()+"\n#");
            printErrorLine(e.getMessage(), input);
        } catch (LexerException e) {
            System.out.println("# Error in "+fileName+": " + e.getMessage() + "\n#");
            printErrorLine(e.getMessage(), input);
        }
	}

    /**
     * Print out the error line and find the position according to the error message
     */
    private static void printErrorLine(String message, String input) {
        int line = Integer.parseInt(message.substring(1, message.indexOf(',')));
        int pos = Integer.parseInt(message.substring(message.indexOf(',') + 1, message.indexOf(']')));
        String[] split = input.split("\n");

        System.out.println("# "+split[line-1]);
        System.out.print("#");
        pos += 0;
        while (pos != 0) {
            System.out.print(" ");
            pos--;
        }
        System.out.println("^\n#");
        System.out.println("# Terminating.\n");
    }

    /**
     * Start one module after the other and try to compile the input file. Then generate the
     * assembler file and create this file for jasmin.
     */
	private static void parse(String input, String fileName) throws ParserException, LexerException, IOException {
		String output;                                          // Init output string
        StringReader reader = new StringReader(input);          // Standard routine to start the parser, lexer, ...
		PushbackReader r = new PushbackReader(reader, 100);
        Lexer l = new Lexer(r);
        Parser parser = new Parser(l);
		Start start = parser.parse();

//        ASTPrinter printer = new ASTPrinter();
//        start.apply(printer);

        TypeChecker typeChecker = new TypeChecker();            // Starting TypeChecker
        start.apply(typeChecker);

        CodeGenerator codeGenerator = new CodeGenerator(typeChecker.getSymbolTable());
        copySymbolTable(typeChecker, codeGenerator);            // To get all the identifiers copied with an index to CodeGen
        start.apply(codeGenerator);

        output = createOutput(codeGenerator, fileName);
//        System.out.println(output);

        Writer wout = new BufferedWriter(                      // Write everything to the outputfile.j
                new OutputStreamWriter(
                        new FileOutputStream(fileName+".j"),"UTF8"));
        wout.append(output);
        wout.close();
    }

    /**
     * Create Header for the jasmin assembler code and add the code of the input file as assembler code
     */
    private static String createOutput(CodeGenerator codeGenerator, String fileName) {
        int size = codeGenerator.getSymbolTable().size()+1;
        return  ".bytecode 50.0\n"+
                ".class public "+fileName+"\n"+
                ".super java/lang/Object\n"+
                ".method public <init>()V\n"+
                    "\t.limit stack 1\n"+
                    "\t.limit locals 1\n"+
                    "\taload_0\n"+
                    "\tinvokespecial java/lang/Object/<init>()V\n"+
                    "\treturn\n"+
                    ".end method\n"+
                    "\t.method public static main([Ljava/lang/String;)V\n"+
                    "\t.limit stack "+codeGenerator.getStackHeight()+"\n"+      // May work...
                    "\t.limit locals "+size+"\n"+
                        codeGenerator.getCode() +
                    "\treturn\n"+
                ".end method\n";
    }

    /**
     * Copy SymbolTable from the TypeChecker to the CodeGenerator and give it a new index
     * (not necessary to know the types any more - they are all correct!)
     */
    private static void copySymbolTable(TypeChecker typeChecker, CodeGenerator codeGenerator) {
        int i = typeChecker.getSymbolTable().size();
        for (String id : typeChecker.getSymbolTable().keySet())
            codeGenerator.getSymbolTable().put(id, i--);
    }
}
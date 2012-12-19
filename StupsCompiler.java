/**************************************************************************
 * Created by Christian Meter on 13th December 2012                       *
 *                                                                        *
 * Mainprogram for the StupsCompiler project                              *
 **************************************************************************
 * Usage: > java StupsCompiler -compile <Filename.pas>                    *
 **************************************************************************/

import lexer.Lexer;
import lexer.LexerException;
import node.Start;
import parser.Parser;
import parser.ParserException;

import java.io.*;

public class StupsCompiler {

	public static void main(String[] args) throws LexerException, IOException, ParserException {
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
                String input = "";
                String zeile;
                FileReader fr = new FileReader(args[1]);
                BufferedReader br = new BufferedReader(fr);

                zeile = br.readLine();
                while (zeile != null) {
                    input += zeile+"\n";
                    zeile = br.readLine();
                }
                br.close();
                parse(input, args[1].substring(0,args[1].lastIndexOf('.')));

            } else if (args[0].equals("-liveness")) {
                // Write something about liveness...
            } else {
                System.out.println("# Error: Wrong usage of StupsCompiler.\n# Usage: > java StupsCompiler -compile <Filename.pas>");
            }
        } catch (FileNotFoundException e) {
            System.out.println("# Error: File '"+args[1]+"' not found. Please enter correct filename.");
        } catch (ParserException e) {
            System.out.println("# Error in: "+e.getMessage()+"\n");
        } catch (LexerException e) {
            System.out.println("# Error in: "+e.getMessage()+"\n");
        }
	}

	private static void parse(String input, String fileName) throws ParserException, LexerException, IOException {
		String output;
        StringReader reader = new StringReader(input);
		PushbackReader r = new PushbackReader(reader, 100);
        Lexer l = new Lexer(r);
        Parser parser = new Parser(l);
		Start start = parser.parse();
        ASTPrinter printer = new ASTPrinter();
        start.apply(printer);

        TypeChecker interpreter = new TypeChecker();
        start.apply(interpreter);

        CodeGenerator visitor = new CodeGenerator(interpreter.symbolTable);
        copySymbolTable(interpreter, visitor);          // To get all the identifiers copied with an index to CodeGen
        start.apply(visitor);

        output = createOutput(visitor);
        System.out.println(output);

        Writer wout = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(fileName+".j"),"UTF8"));
        wout.append(output);
        wout.close();
    }

    private static String createOutput(CodeGenerator visitor) {
        int size = visitor.symbolTable.size()+1;
        return  ".bytecode 50.0\n"+
                ".class public Out\n"+
                ".super java/lang/Object\n"+
                ".method public <init>()V\n"+
                    "\t.limit stack 1\n"+
                    "\t.limit locals 1\n"+
                    "\taload_0\n"+
                    "\tinvokespecial java/lang/Object/<init>()V\n"+
                    "\treturn\n"+
                    ".end method\n"+
                    "\t.method public static main([Ljava/lang/String;)V\n"+
                    "\t.limit stack 100\n"+                                     // NEEDS TO BE UPGRADED
                    "\t.limit locals "+size+"\n"+
                        visitor.code+
                    "\treturn\n"+
                ".end method\n";
    }

    private static void copySymbolTable(TypeChecker interpreter, CodeGenerator visitor) {
        int i = interpreter.symbolTable.size();
        for (String id : interpreter.symbolTable.keySet())
            visitor.symbolTable.put(id, i--);
    }
}
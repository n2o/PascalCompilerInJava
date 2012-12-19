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

//                System.out.println("# Input:  \n"+input);

                parse(input);
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

	private static void parse(String input) throws ParserException, LexerException, IOException {
		StringReader reader = new StringReader(input);
		PushbackReader r = new PushbackReader(reader, 100);
//        System.out.println("# Start Lexing and Parsing...");
        Lexer l = new Lexer(r);
        Parser parser = new Parser(l);
		Start start = parser.parse();
//        System.out.println("# Lexer and Parser: Finished with no errors.\n");

//        System.out.println("# Start printing the AST...");
//        ASTPrinter printer = new ASTPrinter();
//	    start.apply(printer);
//        System.out.println("# AST: Finished with no errors.\n");

//        System.out.println("# Start TypeChecker...");
        TypeChecker interpreter = new TypeChecker();
        start.apply(interpreter);
//        System.out.println("# TypeChecker: Finished with no errors.\n");
//        System.out.println("################################# Success! #################################\n");
	}
}
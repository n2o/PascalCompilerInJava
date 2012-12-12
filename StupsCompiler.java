import lexer.Lexer;
import lexer.LexerException;
import node.Start;
import parser.Parser;
import parser.ParserException;

import java.io.*;

public class StupsCompiler {

	public static void main(String[] args) throws LexerException, IOException, ParserException {
        if (args.length < 2) {
            System.out.println("# Error: Not enough arguments.\n# Usage: > java StupsCompiler -compile <Filename.pas>");
        } else if (args[0].equals("-compile")) {
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

            System.out.println("############################################################################");
            System.out.println("# Input:  \n"+input);
            System.out.println("############################################################################");
            parse(input);
        } else if (args[0].equals("-liveness")) {
            // Write something about liveness...
        } else {
            System.out.println("# Error: Wrong usage of StupsCompiler.\n# Usage: > java StupsCompiler -compile <Filename.pas>");
        }
	}

	private static void parse(String input) throws ParserException, LexerException, IOException {
		StringReader reader = new StringReader(input);
		PushbackReader r = new PushbackReader(reader, 100);
        System.out.println("# Start Lexing and Parsing...");
        Lexer l = new Lexer(r);
        Parser parser = new Parser(l);
		Start start = parser.parse();
        System.out.println("# Lexing and Parsing: Finished with no errors.\n");

        System.out.println("# Start printing the AST...");
        ASTPrinter printer = new ASTPrinter();
		start.apply(printer);
        System.out.println("# AST: Finished with no errors.\n");

        System.out.println("# Start TypeChecker...");
        ASTTypeChecker interpreter = new ASTTypeChecker();
        start.apply(interpreter);
        System.out.println("# TypeChecker: Finished with no errors.\n");
        System.out.println("################################# Success! #################################");
	}
}
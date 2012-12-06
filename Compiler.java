import lexer.Lexer;
import lexer.LexerException;
import node.Start;
import parser.Parser;
import parser.ParserException;

import java.io.*;

public class Compiler {

	public static void main(String[] args) throws LexerException, IOException, ParserException {
        String input = "";
        String zeile;
        FileReader fr = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(fr);

        zeile = br.readLine();
        while (zeile != null) {
            input += zeile+"\n";
            zeile = br.readLine();
        }
        br.close();

		System.out.println("############################################################################");
		System.out.println("# Eingabe:  \n"+input);
		parse(input);
		System.out.println("############################################################################");
	}

	private static void parse(String input) throws ParserException, LexerException, IOException {
		StringReader reader = new StringReader(input);
		PushbackReader r = new PushbackReader(reader, 100);
		Lexer l = new Lexer(r);
		Parser parser = new Parser(l);
		Start start = parser.parse();
		ASTPrinter printer = new ASTPrinter();
		start.apply(printer);
	}
}
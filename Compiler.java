import parser.*;
import lexer.*;
import node.*;
import java.io.*;

public class Compiler {

	public static void main(String[] args) throws LexerException, IOException, ParserException {
		System.out.println("############################################################################");
		String input =  "program HelloWorld; \n";
			   input += "begin \n";
			   input += "\twriteln(Hello World) \n";
			   input += "end. \n";
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
import parser.*;
import lexer.*;
import node.*;
import java.io.*;

public class Compiler {

	public static void main(String args[]) {
		try {
			String filename = args[0];
			File file = new File(filename);
			PushbackReader reader = new PushbackReader(new FileReader(file)); 
			Lexer lexer = new Lexer(reader); 
			Parser parser = new Parser(lexer); 
			Start tree = parser.parse();

			// CodeGen visitor = new CodeGen();
			// tree.apply(visitor); 
			
			String output =
		    	".bytecode 50.0\n"+
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
				"\t.limit stack 10\n"+
				"\t.limit locals "+visitor.countIdentifier+"\n"+
			 	visitor.code+ 
				"\treturn\n"+
				".end method\n";
			// System.out.println(output);

			Writer wout = new BufferedWriter(
			new OutputStreamWriter(
			new FileOutputStream("Out.j"),"UTF8"));
			wout.append(output);
			wout.close();
		} catch(Exception e) {
			System.out.println("Aaaaah irgendein Fehler ist aufgetreten!");
		}
	}
}
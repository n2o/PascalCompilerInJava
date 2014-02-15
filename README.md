# Pascal Compiler in Java

Created a Compiler for Simple Pascal in Java with SableCC. Simple Pascal is a subset of the normal Pascal.

This Compiler takes a Pascal file and creates a *.class file for it, which can be executed using Java as usual.

## Compiling a file and liveness analysis

1. I attached a ```build.xml``` file to use sablecc automatically to use my specified grammar in Java. So just type in your shell: 

  ```> ant```
  
  or by hand:
  
  ```> java -jar sablecc.jar sablecc.scc```

2. Compile all created classes

  ```> javac *.java```

3. Start compiling with:

  ```> java StupsCompiler -compile <Filename.pas>```

4. OR start a liveness analysis for all variables used in the Pascal file

  ```> java StupsCompiler -liveness <Filename.pas>```

5. Create Bytecode with jasmin
 
  ```> java -jar jasmin.jar <Filename.j>```

6. Execute compiled Pascal file

  ```> java Filename```

import analysis.DepthFirstAdapter;
import node.*;

import java.util.HashMap;

public class ASTTypeChecker extends DepthFirstAdapter {

    private HashMap<String, String> symbolTable = new HashMap<String, String>();
    private String result;

    /**
     * Look up all the declarations and put it into the HashMap
     */
    public void caseADeclarationExpr(ADeclarationExpr node) {
        String[] var;
        String type = node.getRight().toString().toLowerCase().replaceAll(" ","");
        var = node.getLeft().toString().toLowerCase().split(" ");
        for (String aVar : var) {
            if (!symbolTable.containsKey(aVar)) {
                symbolTable.put(aVar, type);
            } else {
                System.out.println("# Error: Already specified '" + aVar + "' as '" + symbolTable.get(aVar) + "'. Terminating...");
                System.exit(1);
            }
        }
    }

    @Override
    public void caseAAssignmentExpr(AAssignmentExpr node) {
        String identifier = node.getIdentifier().toString().toLowerCase().replaceAll(" ","");
        checkDeclared(identifier);
        String type = symbolTable.get(identifier);
        String expr = node.getExpr().getClass().getSimpleName();

        node.getExpr().apply(this);     // Going through the AST

        /**
         * If on the right side of := is only a number, check the type of the identifier
         */
        if (expr.equals("ANumberExpr")) {
            if (!type.equals("integer")) {
                System.out.println("# Error: Syntax of a simple assignment is 'integer' ':=' 'integer'.");
                System.exit(1);
            } else {
                printValidOperation("assignment");
            }
        }

        /**
         * If on the right side of := is only an identifier, check both types
         */
        if (expr.equals("AIdentifierExpr")) {
            String matchIdentifier = node.getIdentifier().toString().toLowerCase().replaceAll(" ","");
            checkDeclared(matchIdentifier);
            if (!symbolTable.get(identifier).equals(symbolTable.get(identifier))) {
                System.out.println("# Error: Wrong types. '"+identifier+"' is '"+symbolTable.get(identifier)+"' and '"+matchIdentifier+"' is type '"+symbolTable.get(matchIdentifier)+"'.");
            } else {
                printValidOperation("assignment");
            }
        }

    }

    /**************************************************************************************************
     * Typechecking of all the boolean operations or, xor, and, not
     */
    @Override
    public void caseAOrExpr(AOrExpr node) {
        String operation = "or";
        node.getLeft().apply(this);
        String left = this.result;
        node.getRight().apply(this);
        String right = this.result;

        if (!left.equals(right))
            printErrorBooleanOperation(operation);
        else
            printValidOperation(operation);
    }
    @Override
    public void caseAXorExpr(AXorExpr node) {
        String operation = "xor";
        node.getLeft().apply(this);
        String left = this.result;
        node.getRight().apply(this);
        String right = this.result;

        if (!left.equals(right))
            printErrorBooleanOperation(operation);
        else
            printValidOperation(operation);
    }
    @Override
    public void caseAAndExpr(AAndExpr node) {
        String operation = "and";
        node.getLeft().apply(this);
        String left = this.result;
        node.getRight().apply(this);
        String right = this.result;

        if (!left.equals(right))
            printErrorBooleanOperation(operation);
        else
            printValidOperation(operation);
    }
    @Override
    public void caseANotExpr(ANotExpr node) {
        String operation = "not";
        node.getExpr().apply(this);

        if (!result.equals("boolean"))
            System.out.println("# Error: Syntax of '"+operation+"' is 'not' 'boolean' = 'boolean'.");
        else
            printValidOperation(operation);
    }

    /**************************************************************************************************
     * Typechecking of all the arithmetic operations +, -, *, /, mod
     */
    @Override
    public void caseAPlusExpr(APlusExpr node) {
        String operation = "+";
        node.getLeft().apply(this);
        String left = this.result;
        node.getRight().apply(this);
        String right = this.result;

        if (!left.equals(right))
            printErrorArithmeticOperation(operation);
        else
            printValidOperation(operation);
    }
    @Override
    public void caseAMinusExpr(AMinusExpr node) {
        String operation = "-";
        node.getLeft().apply(this);
        String left = this.result;
        node.getRight().apply(this);
        String right = this.result;

        if (!left.equals(right))
            printErrorArithmeticOperation(operation);
        else
            printValidOperation(operation);
    }
    @Override
    public void caseAModExpr(AModExpr node) {
        String operation = "mod";
        node.getLeft().apply(this);
        String left = this.result;
        node.getRight().apply(this);
        String right = this.result;

        if (!left.equals(right))
            printErrorArithmeticOperation(operation);
        else
            printValidOperation(operation);
    }
    @Override
    public void caseAMultExpr(AMultExpr node) {
        String operation = "*";
        node.getLeft().apply(this);
        String left = this.result;
        node.getRight().apply(this);
        String right = this.result;

        if (!left.equals(right))
            printErrorArithmeticOperation(operation);
        else
            printValidOperation(operation);
    }
    @Override
    public void caseADivExpr(ADivExpr node) {
        String operation = "/";
        node.getLeft().apply(this);
        String left = this.result;
        node.getRight().apply(this);
        String right = this.result;

        if (!left.equals(right))
            printErrorArithmeticOperation(operation);
        else
            printValidOperation(operation);
    }

    /**
     * If a number has been found, write it into result
     */
    @Override
    public void caseANumberExpr(ANumberExpr node) {
        this.result = "integer";
    }

    /**
     * If a boolean has been found, write it into result
     */
    @Override
    public void caseATrueExpr(ATrueExpr node) {
        this.result = "boolean";
    }
    @Override
    public void caseAFalseExpr(AFalseExpr node) {
        this.result = "boolean";
    }

    /**
     * If an identifier has been found, check if it has been declared,
     * look up the entry in the symbolTable and save it in result
     */
    @Override
    public void caseAIdentifierExpr(AIdentifierExpr node) {
        String identifier = node.getIdentifier().toString().toLowerCase().replaceAll(" ","");
        checkDeclared(identifier);
        this.result = symbolTable.get(identifier);
    }


    /************************************************ Own stuff ************************************************/

    /**
     * Check if the variable has been declared
     */
    private void checkDeclared(String identifier) {
        if (!symbolTable.containsKey(identifier)) {
            System.out.println("# Error: Undeclared variable '"+identifier+"' found. Terminating.");
            System.exit(1);
        }
    }

    /**
     * Prepare outputstrings for arithmetic operations
     */
    private void printErrorArithmeticOperation(String operation) {
        System.out.println("# Error: Syntax of '"+operation+"' is 'integer' '"+operation+"' 'integer' = 'integer'.");
        System.exit(1);
    }
    private void printValidOperation(String operation) {
        System.out.println("\t# Found: Valid '"+operation+"' Operation");
    }
    /**
     * The same for boolean expressions
     */
    private void printErrorBooleanOperation(String operation) {
        System.out.println("# Error: Syntax of '"+operation+"' is 'boolean' '"+operation+"' 'boolean' = 'boolean'.");
        System.exit(1);
    }
}

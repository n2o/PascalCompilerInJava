import analysis.DepthFirstAdapter;
import node.AAssignmentExpr;
import node.ADeclarationExpr;
import node.AIdentifierExpr;
import node.APlusExpr;

import java.util.HashMap;

public class ASTInterpreter extends DepthFirstAdapter {

    private HashMap<String, String> symbolTable = new HashMap<String, String>();
    private boolean debug = false;
    private boolean bResult = false;
    private int aResult = 0;
    private String type;

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

        /**
         * For debug use only
         */
        if (debug)
            for (String elem : symbolTable.keySet())
                System.out.println(elem+" -> "+type);
    }

    public void caseAAssignmentExpr(AAssignmentExpr node) {
        String identifier = node.getIdentifier().toString().toLowerCase().replaceAll(" ","");
        checkDeclared(identifier);

        checkNumber(identifier,node);
        node.getExpr().apply(this);

//        System.out.println("# Expr: "+node.getExpr());
//        System.out.println("# Class: "+node.getExpr().getClass());
//        System.out.println(node.getExpr().getClass().getSimpleName());
    }


    public void caseAPlusExpr(APlusExpr node) {
        System.out.println("# Left node: "+node.getLeft());
        System.out.println("# Right node: "+node.getRight());
    }
    public void caseAIdentifierExpr(AIdentifierExpr node) {
        System.out.println("# Found identifier: "+node.getIdentifier().toString());
        String identifier = node.getIdentifier().toString().toLowerCase().replaceAll(" ","");
        checkDeclared(identifier);
        if (symbolTable.get(identifier).equals("boolean")) {
            this.type = "boolean";
        } else {
            this.type = "integer";
        }
    }
    /**
     * Check if it is a simple assignment of a number to a variable of type integer
     */
    private boolean checkNumber(String identifier, AAssignmentExpr node) {
        if (node.getExpr().getClass().getSimpleName().equals("ANumberExpr")) {
            if (symbolTable.get(identifier).equals("integer")) {
                symbolTable.put(identifier, node.getExpr().toString().replaceAll(" ",""));
                System.out.println("# Assigning '"+identifier+"' -> '"+symbolTable.get(identifier)+"'");
                return true;
            }
            else {
                System.out.println("# Error: Assignment not possible, because '"+identifier+"' has not the type 'integer'.");
                System.exit(1);
            }
        }
        return false;
    }

    /**
     * Check if the variable has been declared
     */
    private void checkDeclared(String identifier) {
        if (!symbolTable.containsKey(identifier)) {
            System.out.println("# Error: Undeclared variable '"+identifier+"' found. Terminating.");
            System.exit(1);
        }
    }
}

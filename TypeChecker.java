/**************************************************************************
 * Created by Christian Meter on 13th December 2012                       *
 *                                                                        *
 * Typechecking all the identifiers and their operations                  *
 **************************************************************************
 * Usage: > java StupsCompiler -compile <Filename.pas>                    *
 **************************************************************************/

import analysis.DepthFirstAdapter;
import node.*;

import java.util.HashMap;

public class TypeChecker extends DepthFirstAdapter {

    public HashMap<String, String> symbolTable = new HashMap<String, String>();
    private String result;

    /**
     * Check if break is only used in a while context
     */
    public void caseABreakExpr(ABreakExpr node) {
        Node parent = node.parent();
        String parentName;

        do {
            parent = parent.parent();
            parentName = parent.getClass().getSimpleName().replaceAll(" ","");

            if (parentName.equals("AWhileExpr")) break;

        } while (!parentName.equals("AStartExpr"));

        if (parentName.equals("AStartExpr")) {
            System.out.println("# Error: User 'break' only in a 'while' context!\n");
            System.exit(1);
        }
    }

    /**
     * Look up all the declarations and put it into the HashMap
     */
    @Override
    public void caseADeclarationExpr(ADeclarationExpr node) {
        String type = node.getRight().toString().toLowerCase().replaceAll(" ","");
        String[] var = node.getLeft().toString().toLowerCase().split(" ");

        for (String aVar : var) {
            if (!symbolTable.containsKey(aVar)) {
                symbolTable.put(aVar, type);
            } else {
                System.out.println("# Error: Already specified '" + aVar + "' as '" + symbolTable.get(aVar) + "'. Terminating...\n");
                System.exit(1);
            }
        }
    }

    /**
     * Look up the := operator and it's correct syntax...
     */
    @Override
    public void caseAAssignmentExpr(AAssignmentExpr node) {
        String identifier = node.getIdentifier().toString().toLowerCase().replaceAll(" ","");
        checkDeclared(identifier);
        String type = symbolTable.get(identifier);
        String expr = node.getExpr().getClass().getSimpleName();

        node.getExpr().apply(this);     // Going through the AST

        // Check if arithmetic expressions are
        if (expr.equals("APlusExpr") || expr.equals("AMinusExpr") || expr.equals("AMultExpr") || expr.equals("ADivExpr") || expr.equals("AModExpr") || expr.equals("AUnaryMinusExpr") || expr.equals("AUnaryPlusExpr")) {
            if (!type.equals("integer")) {
                System.out.println("# Error: Wrong types. Expected 'integer'.\n");
                System.exit(1);
            }
        }
        // Check if those comparisons and boolean arithmetic are assigned to booleans
        if (expr.equals("AOrExpr") || expr.equals("AXorExpr") || expr.equals("AAndExpr") || expr.equals("ANotExpr") || expr.equals("AComparisonExpr") ) {
            if (!type.equals("boolean")) {
                System.out.println("# Error: Wrong types. Expected 'boolean'.\n");
                System.exit(1);
            }
        }
        // If on the right side of := is only a number, check the type of the identifier
        if (expr.equals("ANumberExpr")) {
            if (!type.equals("integer")) {
                System.out.println("# Error: Syntax of a simple assignment is: 'integer' ':=' 'integer';\n");
                System.exit(1);
            }
        }
        // If there was only true or false found
        if (expr.equals("ATrueExpr") || expr.equals("AFalseExpr")) {
            if (!type.equals("boolean")) {
                System.out.println("# Error: Can't assign a boolean to an integer.\n");
                System.exit(1);
            }
        }
        // If on the right side of := is only an identifier, check both types
        if (expr.equals("AIdentifierExpr")) {
            String matchIdentifier = node.getIdentifier().toString().toLowerCase().replaceAll(" ","");
            checkDeclared(matchIdentifier);
            if (!symbolTable.get(identifier).equals(symbolTable.get(identifier))) {
                System.out.println("# Error: Wrong types. '"+identifier+"' is '"+symbolTable.get(identifier)+"' and '"+matchIdentifier+"' is type '"+symbolTable.get(matchIdentifier)+"'.\n");
            }
        }
    }


    /**************************************************************************************************
     * Typechecking of all the boolean operations or, xor, and, not and comparisons <, <=, >, ...
     */
    @Override
    public void caseAComparisonExpr(AComparisonExpr node) {
        String operation = "comparison";
        node.getLeft().apply(this);
        String left = this.result;
        node.getRight().apply(this);
        String right = this.result;

        if (!left.equals(right))
            printErrorBooleanOperation(operation);
    }
    @Override
    public void caseAOrExpr(AOrExpr node) {
        String operation = "or";
        node.getLeft().apply(this);
        String left = this.result;
        String right = this.result;

        if (!left.equals(right))
            printErrorBooleanOperation(operation);
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
    }
    @Override
    public void caseANotExpr(ANotExpr node) {
        String operation = "not";
        node.getExpr().apply(this);

        if (!result.equals("boolean")) {
            System.out.println("# Error: Syntax of '" + operation + "' is: 'boolean' := '"+operation+"' 'boolean';\n");
            System.exit(1);
        }
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
    }
    @Override
    public void caseAUnaryMinusExpr(AUnaryMinusExpr node) {
        String operation = "unary -";
        node.getExpr().apply(this);

        if (!result.equals("integer") && !node.getExpr().getClass().getSimpleName().equals("AIdentifierExpr") && !node.getExpr().getClass().getSimpleName().equals("ANumberExpr")) {
            System.out.println("# Error: Syntax of '"+operation+"' is: 'integer' := '"+operation+"' 'integer';\n");
            System.exit(1);
        }
    }
    @Override
    public void caseAUnaryPlusExpr(AUnaryPlusExpr node) {
        String operation = "unary +";
        node.getExpr().apply(this);

        if (!result.equals("integer") && !node.getExpr().getClass().getSimpleName().equals("AIdentifierExpr") && !node.getExpr().getClass().getSimpleName().equals("ANumberExpr")) {
            System.out.println("# Error: Syntax of '"+operation+"' is: 'integer' := '"+operation+"' 'integer';\n");
            System.exit(1);
        }
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
            System.out.println("# Error: Undeclared variable '"+identifier+"' found. Terminating.\n");
            System.exit(1);
        }
    }

    /**
     * Prepare output for arithmetic operations
     */
    private void printErrorArithmeticOperation(String operation) {
        System.out.println("# Error: Syntax of '"+operation+"' is: 'integer' := 'integer' '"+operation+"' 'integer';\n");
        System.exit(1);
    }
    /**
     * The same for boolean expressions
     */
    private void printErrorBooleanOperation(String operation) {
        System.out.println("# Error: Syntax of '"+operation+"' is: 'boolean' := 'boolean' '"+operation+"' 'boolean';\n");
        System.exit(1);
    }
}

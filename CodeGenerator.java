import analysis.DepthFirstAdapter;
import node.*;

import java.util.HashMap;

/**
 * Need to test:
 *  - UnaryMinus
 *  - UnaryPlus not necessary?
 */

public class CodeGenerator extends DepthFirstAdapter {
    public String code = "";
    public HashMap<String, Integer> symbolTable = new HashMap<String, Integer>();
    private HashMap<String, String> typeTable;
    private String type = "";
    private int countLabels = 0;

    public CodeGenerator(HashMap<String, String> symbolTable) {
        typeTable = symbolTable;
    }

    // Boolean expressions
    @Override
    public void outAAndExpr(AAndExpr node) {
        code += "\tiand\n";
        type = "boolean";
    }
    @Override
    public void outAOrExpr(AOrExpr node) {
        code += "\tior\n";
        type = "boolean";
    }
    @Override
    public void outAXorExpr(AXorExpr node) {
        code += "\tixor\n";
        type = "boolean";
    }
    @Override
    public void outANotExpr(ANotExpr node) {
        code += "\tineg\n";
        type = "boolean";
    }
    @Override
    public void outATrueExpr(ATrueExpr node) {
        code += "\tbipush 1\n";
        type = "boolean";
    }
    @Override
    public void outAFalseExpr(AFalseExpr node) {
        code += "\tbipush 0\n";
        type = "boolean";
    }

    // Arithmetic operations
    @Override
    public void outAPlusExpr(APlusExpr node) {
        code += "\tiadd\n";
        type = "integer";
    }
    @Override
    public void outAMinusExpr(AMinusExpr node) {
        code += "\tisub\n";
        type = "integer";
    }
    @Override                                               // NEED TO TEST THIS!
    public void outAUnaryMinusExpr(AUnaryMinusExpr node) {
        code += "\tineg\n";
        type = "integer";
    }
    @Override
    public void outAMultExpr(AMultExpr node) {
        code += "\timul\n";
        type = "integer";
    }
    @Override
    public void outADivExpr(ADivExpr node) {
        code += "\tidiv\n";
        type = "integer";
    }
    @Override
    public void outAModExpr(AModExpr node) {
        code += "\tirem\n";
        type = "integer";
    }

    // Comparisons

    // Identifier
    @Override
    public void outAIdentifierExpr(AIdentifierExpr node) {
        boolean check = true;
        String identifier = node.getIdentifier().toString().toLowerCase().replaceAll(" ","");
        Node parent = node;
        String parentName;
        do {
            parent = parent.parent();
            parentName = parent.getClass().getSimpleName().replaceAll(" ","");
            if (parentName.equals("ADeclarationExpr")) check = false;

        } while (!parentName.equals("AStartExpr"));

        if (check) {
            code += "\tiload "+symbolTable.get(identifier)+"\n";
            type = typeTable.get(identifier);
        }
    }

    // Check assignment and save expression in the variable
    @Override
    public void caseAAssignmentExpr(AAssignmentExpr node) {
        node.getExpr().apply(this);
        code += "\tistore "+symbolTable.get(node.getIdentifier().toString().toLowerCase().replaceAll(" ",""))+"\n";
    }
    @Override
    public void caseANumberExpr(ANumberExpr node) {
        code += "\tldc "+node.getNumber().toString().replaceAll(" ","")+"\n";
        type = "integer";
    }
    @Override
    public void caseATrueExpr(ATrueExpr node) {
        code += "\tldc 1\n";
        type = "boolean";
    }
    @Override
    public void caseAFalseExpr(AFalseExpr node) {
        code += "\tldc 0\n";
        type = "boolean";
    }
    @Override
    public void caseAPrintExpr(APrintExpr node) {
        String intOrBoolean = "I";

        code += "\tgetstatic java/lang/System/out Ljava/io/PrintStream;\n";
        node.getExpr().apply(this);
        if (type.equals("boolean")) intOrBoolean = "Z";
        code += "\tinvokevirtual java/io/PrintStream/println("+intOrBoolean+")V\n";
    }

    // While loop
    @Override
    public void caseAWhileExpr(AWhileExpr node) {
        code += "\tLabel"+countLabels+":\n";
        node.getLeft().apply(this);
        code += "\ndone\n";
    }

    // Comparisons
    @Override
    public void caseAComparisonExpr(AComparisonExpr node) {
        String compare = node.getComparison().toString().toLowerCase().replaceAll(" ","");
        if (compare.equals("<")) {
            System.out.println("bombe");
        }

    }
}

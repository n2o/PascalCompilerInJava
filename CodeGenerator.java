import analysis.DepthFirstAdapter;
import node.*;

import java.util.HashMap;

/**
 * Need to test:
 *  - UnaryPlus not necessary?
 */

public class CodeGenerator extends DepthFirstAdapter {
    private String code = "";
    private HashMap<String, Integer> symbolTable = new HashMap<String, Integer>();
    private HashMap<String, String> typeTable;
    private String type = "";
    private int countLabels = 0;
    private int compareCounter = 0;
    private int breakCounter = 0;
    private int stackHeight = 1;

    public CodeGenerator(HashMap<String, String> symbolTable) {
        typeTable = symbolTable;
    }

    // Boolean expressions
    @Override
    public void outAAndExpr(AAndExpr node) {
        code += "\tiand\n";
        stackHeight--;
        type = "boolean";
    }
    @Override
    public void outAOrExpr(AOrExpr node) {
        code += "\tior\n";
        stackHeight--;
        type = "boolean";
    }
    @Override
    public void outAXorExpr(AXorExpr node) {
        code += "\tixor\n";
        stackHeight--;
        type = "boolean";
    }
    @Override
    public void outANotExpr(ANotExpr node) {
        int temp = countLabels++;
        code += "\tifeq LabelNotTrue"+temp+"\n";
        code += "\tbipush 0\n";
        code += "\tgoto LabelNotEnd"+temp+"\n";
        code += "LabelNotTrue"+temp+":\n";
        code += "\tbipush 1\n";
        code += "\tLabelNotEnd"+temp+":\n";
        type = "boolean";
    }
    // Arithmetic operations
    @Override
    public void outAPlusExpr(APlusExpr node) {
        code += "\tiadd\n";
        stackHeight--;
        type = "integer";
    }
    @Override
    public void outAMinusExpr(AMinusExpr node) {
        code += "\tisub\n";
        stackHeight--;
        type = "integer";
    }

    // Arithmetic expressions
    @Override                                               // NEED TO TEST THIS!
    public void outAUnaryMinusExpr(AUnaryMinusExpr node) {
        code += "\tineg\n";
        type = "integer";
    }
    @Override
    public void outAMultExpr(AMultExpr node) {
        code += "\timul\n";
        stackHeight--;
        type = "integer";
    }
    @Override
    public void outADivExpr(ADivExpr node) {
        code += "\tidiv\n";
        stackHeight--;
        type = "integer";
    }
    @Override
    public void outAModExpr(AModExpr node) {
        code += "\tirem\n";
        type = "integer";
    }

    // Check identifier
    @Override
    public void outAIdentifierExpr(AIdentifierExpr node) {
        boolean check = true;
        String identifier = node.getIdentifier().toString().toLowerCase().replaceAll(" ","");
        Node parent = node;
        String parentName;
        do {        // Needed to check, if we are in a declaration-context
            parent = parent.parent();
            parentName = parent.getClass().getSimpleName().replaceAll(" ","");
            if (parentName.equals("ADeclarationExpr")) check = false;

        } while (!parentName.equals("AStartExpr"));

        if (check) {
            code += "\tiload "+symbolTable.get(identifier)+"\n";
            stackHeight++;
            type = typeTable.get(identifier);
        }
    }

    // Check assignment and save expression in the variable
    @Override
    public void caseAAssignmentExpr(AAssignmentExpr node) {
        node.getExpr().apply(this);
        code += "\tistore "+symbolTable.get(node.getIdentifier().toString().toLowerCase().replaceAll(" ",""))+"\n";
        stackHeight--;
    }
    @Override
    public void caseANumberExpr(ANumberExpr node) {
        int number = Integer.parseInt(node.getNumber().toString().replaceAll(" ", ""));
        if (number > 255)
            code += "\tldc "+number+"\n";
        else
            code += "\tbipush "+number+"\n";
        stackHeight++;
        type = "integer";
    }
    @Override
    public void caseATrueExpr(ATrueExpr node) {
        code += "\tbipush 1\n";
        stackHeight++;
        type = "boolean";
    }
    @Override
    public void caseAFalseExpr(AFalseExpr node) {
        code += "\tbipush 0\n";
        stackHeight++;
        type = "boolean";
    }
    @Override
    public void caseAPrintExpr(APrintExpr node) {
        String intOrBoolean = "I";
        code += "\tgetstatic java/lang/System/out Ljava/io/PrintStream;\n";
        node.getExpr().apply(this);
        if (type.equals("boolean")) intOrBoolean = "Z";
        code += "\tinvokevirtual java/io/PrintStream/println("+intOrBoolean+")V\n";
        stackHeight++;
    }

    // While loop
    @Override
    public void caseAWhileExpr(AWhileExpr node) {
        int temp = countLabels++;
        code += "LabelWhileUp"+temp+":\n";
        node.getLeft().apply(this);
        code += "\tifeq LabelWhileDown"+temp+"\n";
        stackHeight--;
        node.getRight().apply(this);
        code += "\tgoto LabelWhileUp"+temp+"\n";
        code += "LabelWhileDown"+temp+":\n";
        code += "LabelBreakDown"+(breakCounter++)+":\n";
    }

    // Break
    @Override
    public void caseABreakExpr(ABreakExpr node) {
        code += "\tgoto LabelBreakDown"+breakCounter+"\n";
    }

    // If-then Part
    @Override
    public void caseAIfThenExpr(AIfThenExpr node) {
        int temp = countLabels++;
        node.getLeft().apply(this);
        code += "\tifeq LabelIfDown"+temp+"\n";
        stackHeight--;
        node.getRight().apply(this);
        code += "LabelIfDown"+temp+":\n";
    }

    // If-then-else Part
    @Override
    public void caseAIfThenElseExpr(AIfThenElseExpr node) {
        int temp = countLabels++;
        node.getIf().apply(this);
        code += "\tifeq LabelIfElse"+temp+"\n";
        stackHeight--;
        node.getThen().apply(this);
        code += "\tgoto LabelIfElseEnd"+temp+"\n";
        code += "LabelIfElse"+temp+":\n";
        node.getElse().apply(this);
        code += "LabelIfElseEnd"+temp+":\n";
    }

    // Comparisons
    @Override
    public void caseAComparisonExpr(AComparisonExpr node) {
        int temp = 0;
        node.getLeft().apply(this);
        node.getRight().apply(this);
        code += "\tisub\n";         // To check with zero
        stackHeight--;
        temp = compareCounter;
        node.getComparison().apply(this);   // Add line matching to corresponding symbol
        code += "\tbipush 0\n";
        stackHeight++;
        code += "\tgoto LabelCompEnd"+temp+"\n";
        code += "LabelTrue"+temp+":\n";
        code += "\tbipush 1\n";
        stackHeight++;
        code += "LabelCompEnd"+temp+":\n";
    }
    @Override
    public void outAGtExpr(AGtExpr node) {
        code += "\tifgt LabelTrue"+(compareCounter++)+"\n";
        stackHeight--;
    }
    @Override
    public void outAGeExpr(AGeExpr node) {
        code += "\tifge LabelTrue"+(compareCounter++)+"\n";
        stackHeight--;
    }
    @Override
    public void outALtExpr(ALtExpr node) {
        code += "\tiflt LabelTrue"+(compareCounter++)+"\n";
        stackHeight--;
    }
    @Override
    public void outALeExpr(ALeExpr node) {
        code += "\tifle LabelTrue"+(compareCounter++)+"\n";
        stackHeight--;
    }
    @Override
    public void outANeExpr(ANeExpr node) {
        code += "\tifne LabelTrue"+(compareCounter++)+"\n";
        stackHeight--;
    }
    @Override
    public void outAEqExpr(AEqExpr node) {
        code += "\tifeq LabelTrue"+(compareCounter++)+"\n";
        stackHeight--;
    }

    /********************************* Getter and Setter **************************************/
    public HashMap<String, Integer> getSymbolTable() {
        return symbolTable;
    }
    public String getCode() {
        return code;
    }
    public int getStackHeight() {
        return stackHeight;
    }
}

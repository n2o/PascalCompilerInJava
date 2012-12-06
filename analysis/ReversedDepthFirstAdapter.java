/* This file was generated by SableCC (http://www.sablecc.org/). */

package analysis;

import java.util.*;
import node.*;

public class ReversedDepthFirstAdapter extends AnalysisAdapter
{
    public void inStart(Start node)
    {
        defaultIn(node);
    }

    public void outStart(Start node)
    {
        defaultOut(node);
    }

    public void defaultIn(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    public void defaultOut(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    @Override
    public void caseStart(Start node)
    {
        inStart(node);
        node.getEOF().apply(this);
        node.getPStart().apply(this);
        outStart(node);
    }

    public void inAStart(AStart node)
    {
        defaultIn(node);
    }

    public void outAStart(AStart node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAStart(AStart node)
    {
        inAStart(node);
        if(node.getProgramend() != null)
        {
            node.getProgramend().apply(this);
        }
        {
            List<PStatement> copy = new ArrayList<PStatement>(node.getStatement());
            Collections.reverse(copy);
            for(PStatement e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getBegin() != null)
        {
            node.getBegin().apply(this);
        }
        {
            List<PDeclarations> copy = new ArrayList<PDeclarations>(node.getDeclarations());
            Collections.reverse(copy);
            for(PDeclarations e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getSemicolon() != null)
        {
            node.getSemicolon().apply(this);
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        if(node.getProgram() != null)
        {
            node.getProgram().apply(this);
        }
        outAStart(node);
    }

    public void inASingleDeclarations(ASingleDeclarations node)
    {
        defaultIn(node);
    }

    public void outASingleDeclarations(ASingleDeclarations node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASingleDeclarations(ASingleDeclarations node)
    {
        inASingleDeclarations(node);
        if(node.getSemicolon() != null)
        {
            node.getSemicolon().apply(this);
        }
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        if(node.getColon() != null)
        {
            node.getColon().apply(this);
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        outASingleDeclarations(node);
    }

    public void inAIfThenStatementStatement(AIfThenStatementStatement node)
    {
        defaultIn(node);
    }

    public void outAIfThenStatementStatement(AIfThenStatementStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIfThenStatementStatement(AIfThenStatementStatement node)
    {
        inAIfThenStatementStatement(node);
        if(node.getIfThenStatement() != null)
        {
            node.getIfThenStatement().apply(this);
        }
        outAIfThenStatementStatement(node);
    }

    public void inAIfThenElseStatementStatement(AIfThenElseStatementStatement node)
    {
        defaultIn(node);
    }

    public void outAIfThenElseStatementStatement(AIfThenElseStatementStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIfThenElseStatementStatement(AIfThenElseStatementStatement node)
    {
        inAIfThenElseStatementStatement(node);
        if(node.getIfThenElseStatement() != null)
        {
            node.getIfThenElseStatement().apply(this);
        }
        outAIfThenElseStatementStatement(node);
    }

    public void inAWhileStatement(AWhileStatement node)
    {
        defaultIn(node);
    }

    public void outAWhileStatement(AWhileStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAWhileStatement(AWhileStatement node)
    {
        inAWhileStatement(node);
        if(node.getWhileStatement() != null)
        {
            node.getWhileStatement().apply(this);
        }
        outAWhileStatement(node);
    }

    public void inAAssignStatement(AAssignStatement node)
    {
        defaultIn(node);
    }

    public void outAAssignStatement(AAssignStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAssignStatement(AAssignStatement node)
    {
        inAAssignStatement(node);
        if(node.getAssignment() != null)
        {
            node.getAssignment().apply(this);
        }
        outAAssignStatement(node);
    }

    public void inAPrintStatement(APrintStatement node)
    {
        defaultIn(node);
    }

    public void outAPrintStatement(APrintStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPrintStatement(APrintStatement node)
    {
        inAPrintStatement(node);
        if(node.getPrint() != null)
        {
            node.getPrint().apply(this);
        }
        outAPrintStatement(node);
    }

    public void inANestedStatement(ANestedStatement node)
    {
        defaultIn(node);
    }

    public void outANestedStatement(ANestedStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANestedStatement(ANestedStatement node)
    {
        inANestedStatement(node);
        if(node.getEnd() != null)
        {
            node.getEnd().apply(this);
        }
        {
            List<PStatement> copy = new ArrayList<PStatement>(node.getStatement());
            Collections.reverse(copy);
            for(PStatement e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getBegin() != null)
        {
            node.getBegin().apply(this);
        }
        outANestedStatement(node);
    }

    public void inABreakStatement(ABreakStatement node)
    {
        defaultIn(node);
    }

    public void outABreakStatement(ABreakStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseABreakStatement(ABreakStatement node)
    {
        inABreakStatement(node);
        if(node.getSemicolon() != null)
        {
            node.getSemicolon().apply(this);
        }
        if(node.getBreak() != null)
        {
            node.getBreak().apply(this);
        }
        outABreakStatement(node);
    }

    public void inAStatement(AStatement node)
    {
        defaultIn(node);
    }

    public void outAStatement(AStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAStatement(AStatement node)
    {
        inAStatement(node);
        if(node.getSemicolon() != null)
        {
            node.getSemicolon().apply(this);
        }
        outAStatement(node);
    }

    public void inAIfStatementNoShortIf(AIfStatementNoShortIf node)
    {
        defaultIn(node);
    }

    public void outAIfStatementNoShortIf(AIfStatementNoShortIf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIfStatementNoShortIf(AIfStatementNoShortIf node)
    {
        inAIfStatementNoShortIf(node);
        if(node.getIfThenElseStatementNoShortIf() != null)
        {
            node.getIfThenElseStatementNoShortIf().apply(this);
        }
        outAIfStatementNoShortIf(node);
    }

    public void inAWhileStatementNoShortIf(AWhileStatementNoShortIf node)
    {
        defaultIn(node);
    }

    public void outAWhileStatementNoShortIf(AWhileStatementNoShortIf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAWhileStatementNoShortIf(AWhileStatementNoShortIf node)
    {
        inAWhileStatementNoShortIf(node);
        if(node.getWhileStatementNoShortIf() != null)
        {
            node.getWhileStatementNoShortIf().apply(this);
        }
        outAWhileStatementNoShortIf(node);
    }

    public void inAAssignStatementNoShortIf(AAssignStatementNoShortIf node)
    {
        defaultIn(node);
    }

    public void outAAssignStatementNoShortIf(AAssignStatementNoShortIf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAssignStatementNoShortIf(AAssignStatementNoShortIf node)
    {
        inAAssignStatementNoShortIf(node);
        if(node.getAssignment() != null)
        {
            node.getAssignment().apply(this);
        }
        outAAssignStatementNoShortIf(node);
    }

    public void inAPrintStatementNoShortIf(APrintStatementNoShortIf node)
    {
        defaultIn(node);
    }

    public void outAPrintStatementNoShortIf(APrintStatementNoShortIf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPrintStatementNoShortIf(APrintStatementNoShortIf node)
    {
        inAPrintStatementNoShortIf(node);
        if(node.getPrint() != null)
        {
            node.getPrint().apply(this);
        }
        outAPrintStatementNoShortIf(node);
    }

    public void inANestedStatementNoShortIf(ANestedStatementNoShortIf node)
    {
        defaultIn(node);
    }

    public void outANestedStatementNoShortIf(ANestedStatementNoShortIf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANestedStatementNoShortIf(ANestedStatementNoShortIf node)
    {
        inANestedStatementNoShortIf(node);
        if(node.getEnd() != null)
        {
            node.getEnd().apply(this);
        }
        {
            List<PStatement> copy = new ArrayList<PStatement>(node.getStatement());
            Collections.reverse(copy);
            for(PStatement e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getBegin() != null)
        {
            node.getBegin().apply(this);
        }
        outANestedStatementNoShortIf(node);
    }

    public void inABreakStatementNoShortIf(ABreakStatementNoShortIf node)
    {
        defaultIn(node);
    }

    public void outABreakStatementNoShortIf(ABreakStatementNoShortIf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseABreakStatementNoShortIf(ABreakStatementNoShortIf node)
    {
        inABreakStatementNoShortIf(node);
        if(node.getBreak() != null)
        {
            node.getBreak().apply(this);
        }
        outABreakStatementNoShortIf(node);
    }

    public void inAStatementNoShortIf(AStatementNoShortIf node)
    {
        defaultIn(node);
    }

    public void outAStatementNoShortIf(AStatementNoShortIf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAStatementNoShortIf(AStatementNoShortIf node)
    {
        inAStatementNoShortIf(node);
        if(node.getSemicolon() != null)
        {
            node.getSemicolon().apply(this);
        }
        outAStatementNoShortIf(node);
    }

    public void inAWhileWhileStatementNoShortIf(AWhileWhileStatementNoShortIf node)
    {
        defaultIn(node);
    }

    public void outAWhileWhileStatementNoShortIf(AWhileWhileStatementNoShortIf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAWhileWhileStatementNoShortIf(AWhileWhileStatementNoShortIf node)
    {
        inAWhileWhileStatementNoShortIf(node);
        if(node.getStatementNoShortIf() != null)
        {
            node.getStatementNoShortIf().apply(this);
        }
        if(node.getDo() != null)
        {
            node.getDo().apply(this);
        }
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        if(node.getWhile() != null)
        {
            node.getWhile().apply(this);
        }
        outAWhileWhileStatementNoShortIf(node);
    }

    public void inAWhileWhileStatement(AWhileWhileStatement node)
    {
        defaultIn(node);
    }

    public void outAWhileWhileStatement(AWhileWhileStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAWhileWhileStatement(AWhileWhileStatement node)
    {
        inAWhileWhileStatement(node);
        if(node.getStatement() != null)
        {
            node.getStatement().apply(this);
        }
        if(node.getDo() != null)
        {
            node.getDo().apply(this);
        }
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        if(node.getWhile() != null)
        {
            node.getWhile().apply(this);
        }
        outAWhileWhileStatement(node);
    }

    public void inAPrint(APrint node)
    {
        defaultIn(node);
    }

    public void outAPrint(APrint node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPrint(APrint node)
    {
        inAPrint(node);
        if(node.getRPar() != null)
        {
            node.getRPar().apply(this);
        }
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        if(node.getLPar() != null)
        {
            node.getLPar().apply(this);
        }
        if(node.getWriteln() != null)
        {
            node.getWriteln().apply(this);
        }
        outAPrint(node);
    }

    public void inAAssignment(AAssignment node)
    {
        defaultIn(node);
    }

    public void outAAssignment(AAssignment node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAssignment(AAssignment node)
    {
        inAAssignment(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        if(node.getAssign() != null)
        {
            node.getAssign().apply(this);
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outAAssignment(node);
    }

    public void inABooleanType(ABooleanType node)
    {
        defaultIn(node);
    }

    public void outABooleanType(ABooleanType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseABooleanType(ABooleanType node)
    {
        inABooleanType(node);
        if(node.getBoolean() != null)
        {
            node.getBoolean().apply(this);
        }
        outABooleanType(node);
    }

    public void inAIntegerType(AIntegerType node)
    {
        defaultIn(node);
    }

    public void outAIntegerType(AIntegerType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIntegerType(AIntegerType node)
    {
        inAIntegerType(node);
        if(node.getInteger() != null)
        {
            node.getInteger().apply(this);
        }
        outAIntegerType(node);
    }

    public void inAComparisionExpression(AComparisionExpression node)
    {
        defaultIn(node);
    }

    public void outAComparisionExpression(AComparisionExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAComparisionExpression(AComparisionExpression node)
    {
        inAComparisionExpression(node);
        if(node.getExpression2() != null)
        {
            node.getExpression2().apply(this);
        }
        if(node.getComparision() != null)
        {
            node.getComparision().apply(this);
        }
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        outAComparisionExpression(node);
    }

    public void inAExpression(AExpression node)
    {
        defaultIn(node);
    }

    public void outAExpression(AExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExpression(AExpression node)
    {
        inAExpression(node);
        if(node.getExpression2() != null)
        {
            node.getExpression2().apply(this);
        }
        outAExpression(node);
    }

    public void inAPlusExpression2(APlusExpression2 node)
    {
        defaultIn(node);
    }

    public void outAPlusExpression2(APlusExpression2 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPlusExpression2(APlusExpression2 node)
    {
        inAPlusExpression2(node);
        if(node.getExpression3() != null)
        {
            node.getExpression3().apply(this);
        }
        if(node.getPlus() != null)
        {
            node.getPlus().apply(this);
        }
        if(node.getExpression2() != null)
        {
            node.getExpression2().apply(this);
        }
        outAPlusExpression2(node);
    }

    public void inAMinusExpression2(AMinusExpression2 node)
    {
        defaultIn(node);
    }

    public void outAMinusExpression2(AMinusExpression2 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMinusExpression2(AMinusExpression2 node)
    {
        inAMinusExpression2(node);
        if(node.getExpression3() != null)
        {
            node.getExpression3().apply(this);
        }
        if(node.getMinus() != null)
        {
            node.getMinus().apply(this);
        }
        if(node.getExpression2() != null)
        {
            node.getExpression2().apply(this);
        }
        outAMinusExpression2(node);
    }

    public void inAOrExpression2(AOrExpression2 node)
    {
        defaultIn(node);
    }

    public void outAOrExpression2(AOrExpression2 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAOrExpression2(AOrExpression2 node)
    {
        inAOrExpression2(node);
        if(node.getExpression3() != null)
        {
            node.getExpression3().apply(this);
        }
        if(node.getOr() != null)
        {
            node.getOr().apply(this);
        }
        if(node.getExpression2() != null)
        {
            node.getExpression2().apply(this);
        }
        outAOrExpression2(node);
    }

    public void inAXorExpression2(AXorExpression2 node)
    {
        defaultIn(node);
    }

    public void outAXorExpression2(AXorExpression2 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAXorExpression2(AXorExpression2 node)
    {
        inAXorExpression2(node);
        if(node.getExpression3() != null)
        {
            node.getExpression3().apply(this);
        }
        if(node.getXor() != null)
        {
            node.getXor().apply(this);
        }
        if(node.getExpression2() != null)
        {
            node.getExpression2().apply(this);
        }
        outAXorExpression2(node);
    }

    public void inAExpression2(AExpression2 node)
    {
        defaultIn(node);
    }

    public void outAExpression2(AExpression2 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExpression2(AExpression2 node)
    {
        inAExpression2(node);
        if(node.getExpression3() != null)
        {
            node.getExpression3().apply(this);
        }
        outAExpression2(node);
    }

    public void inAModExpression3(AModExpression3 node)
    {
        defaultIn(node);
    }

    public void outAModExpression3(AModExpression3 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAModExpression3(AModExpression3 node)
    {
        inAModExpression3(node);
        if(node.getExpression4() != null)
        {
            node.getExpression4().apply(this);
        }
        if(node.getMod() != null)
        {
            node.getMod().apply(this);
        }
        if(node.getExpression3() != null)
        {
            node.getExpression3().apply(this);
        }
        outAModExpression3(node);
    }

    public void inAMultExpression3(AMultExpression3 node)
    {
        defaultIn(node);
    }

    public void outAMultExpression3(AMultExpression3 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMultExpression3(AMultExpression3 node)
    {
        inAMultExpression3(node);
        if(node.getExpression4() != null)
        {
            node.getExpression4().apply(this);
        }
        if(node.getMult() != null)
        {
            node.getMult().apply(this);
        }
        if(node.getExpression3() != null)
        {
            node.getExpression3().apply(this);
        }
        outAMultExpression3(node);
    }

    public void inADivExpression3(ADivExpression3 node)
    {
        defaultIn(node);
    }

    public void outADivExpression3(ADivExpression3 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADivExpression3(ADivExpression3 node)
    {
        inADivExpression3(node);
        if(node.getExpression4() != null)
        {
            node.getExpression4().apply(this);
        }
        if(node.getDiv() != null)
        {
            node.getDiv().apply(this);
        }
        if(node.getExpression3() != null)
        {
            node.getExpression3().apply(this);
        }
        outADivExpression3(node);
    }

    public void inAAndExpression3(AAndExpression3 node)
    {
        defaultIn(node);
    }

    public void outAAndExpression3(AAndExpression3 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAndExpression3(AAndExpression3 node)
    {
        inAAndExpression3(node);
        if(node.getExpression4() != null)
        {
            node.getExpression4().apply(this);
        }
        if(node.getAnd() != null)
        {
            node.getAnd().apply(this);
        }
        if(node.getExpression3() != null)
        {
            node.getExpression3().apply(this);
        }
        outAAndExpression3(node);
    }

    public void inAExpression3(AExpression3 node)
    {
        defaultIn(node);
    }

    public void outAExpression3(AExpression3 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExpression3(AExpression3 node)
    {
        inAExpression3(node);
        if(node.getExpression4() != null)
        {
            node.getExpression4().apply(this);
        }
        outAExpression3(node);
    }

    public void inANotExpression4(ANotExpression4 node)
    {
        defaultIn(node);
    }

    public void outANotExpression4(ANotExpression4 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANotExpression4(ANotExpression4 node)
    {
        inANotExpression4(node);
        if(node.getExpression4() != null)
        {
            node.getExpression4().apply(this);
        }
        if(node.getNot() != null)
        {
            node.getNot().apply(this);
        }
        outANotExpression4(node);
    }

    public void inANumberExpression4(ANumberExpression4 node)
    {
        defaultIn(node);
    }

    public void outANumberExpression4(ANumberExpression4 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANumberExpression4(ANumberExpression4 node)
    {
        inANumberExpression4(node);
        if(node.getNumber() != null)
        {
            node.getNumber().apply(this);
        }
        outANumberExpression4(node);
    }

    public void inAIdentifierExpression4(AIdentifierExpression4 node)
    {
        defaultIn(node);
    }

    public void outAIdentifierExpression4(AIdentifierExpression4 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIdentifierExpression4(AIdentifierExpression4 node)
    {
        inAIdentifierExpression4(node);
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outAIdentifierExpression4(node);
    }

    public void inATrueExpression4(ATrueExpression4 node)
    {
        defaultIn(node);
    }

    public void outATrueExpression4(ATrueExpression4 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATrueExpression4(ATrueExpression4 node)
    {
        inATrueExpression4(node);
        if(node.getTrue() != null)
        {
            node.getTrue().apply(this);
        }
        outATrueExpression4(node);
    }

    public void inAFalseExpression4(AFalseExpression4 node)
    {
        defaultIn(node);
    }

    public void outAFalseExpression4(AFalseExpression4 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFalseExpression4(AFalseExpression4 node)
    {
        inAFalseExpression4(node);
        if(node.getFalse() != null)
        {
            node.getFalse().apply(this);
        }
        outAFalseExpression4(node);
    }

    public void inAGtComparision(AGtComparision node)
    {
        defaultIn(node);
    }

    public void outAGtComparision(AGtComparision node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAGtComparision(AGtComparision node)
    {
        inAGtComparision(node);
        if(node.getGt() != null)
        {
            node.getGt().apply(this);
        }
        outAGtComparision(node);
    }

    public void inAGeComparision(AGeComparision node)
    {
        defaultIn(node);
    }

    public void outAGeComparision(AGeComparision node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAGeComparision(AGeComparision node)
    {
        inAGeComparision(node);
        if(node.getGe() != null)
        {
            node.getGe().apply(this);
        }
        outAGeComparision(node);
    }

    public void inALtComparision(ALtComparision node)
    {
        defaultIn(node);
    }

    public void outALtComparision(ALtComparision node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALtComparision(ALtComparision node)
    {
        inALtComparision(node);
        if(node.getLt() != null)
        {
            node.getLt().apply(this);
        }
        outALtComparision(node);
    }

    public void inALeComparision(ALeComparision node)
    {
        defaultIn(node);
    }

    public void outALeComparision(ALeComparision node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALeComparision(ALeComparision node)
    {
        inALeComparision(node);
        if(node.getLe() != null)
        {
            node.getLe().apply(this);
        }
        outALeComparision(node);
    }

    public void inANeComparision(ANeComparision node)
    {
        defaultIn(node);
    }

    public void outANeComparision(ANeComparision node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANeComparision(ANeComparision node)
    {
        inANeComparision(node);
        if(node.getNe() != null)
        {
            node.getNe().apply(this);
        }
        outANeComparision(node);
    }

    public void inAEqComparision(AEqComparision node)
    {
        defaultIn(node);
    }

    public void outAEqComparision(AEqComparision node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEqComparision(AEqComparision node)
    {
        inAEqComparision(node);
        if(node.getEq() != null)
        {
            node.getEq().apply(this);
        }
        outAEqComparision(node);
    }

    public void inAIfThenStatement(AIfThenStatement node)
    {
        defaultIn(node);
    }

    public void outAIfThenStatement(AIfThenStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIfThenStatement(AIfThenStatement node)
    {
        inAIfThenStatement(node);
        if(node.getStatement() != null)
        {
            node.getStatement().apply(this);
        }
        if(node.getThen() != null)
        {
            node.getThen().apply(this);
        }
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        if(node.getIf() != null)
        {
            node.getIf().apply(this);
        }
        outAIfThenStatement(node);
    }

    public void inAIfThenElseStatement(AIfThenElseStatement node)
    {
        defaultIn(node);
    }

    public void outAIfThenElseStatement(AIfThenElseStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIfThenElseStatement(AIfThenElseStatement node)
    {
        inAIfThenElseStatement(node);
        if(node.getStatement() != null)
        {
            node.getStatement().apply(this);
        }
        if(node.getElse() != null)
        {
            node.getElse().apply(this);
        }
        if(node.getStatementNoShortIf() != null)
        {
            node.getStatementNoShortIf().apply(this);
        }
        if(node.getThen() != null)
        {
            node.getThen().apply(this);
        }
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        if(node.getIf() != null)
        {
            node.getIf().apply(this);
        }
        outAIfThenElseStatement(node);
    }

    public void inAIfThenElseStatementNoShortIf(AIfThenElseStatementNoShortIf node)
    {
        defaultIn(node);
    }

    public void outAIfThenElseStatementNoShortIf(AIfThenElseStatementNoShortIf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIfThenElseStatementNoShortIf(AIfThenElseStatementNoShortIf node)
    {
        inAIfThenElseStatementNoShortIf(node);
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        if(node.getElse() != null)
        {
            node.getElse().apply(this);
        }
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getThen() != null)
        {
            node.getThen().apply(this);
        }
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        if(node.getIf() != null)
        {
            node.getIf().apply(this);
        }
        outAIfThenElseStatementNoShortIf(node);
    }
}

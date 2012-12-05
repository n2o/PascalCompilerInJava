/* This file was generated by SableCC (http://www.sablecc.org/). */

package analysis;

import node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object o);
    Object getOut(Node node);
    void setOut(Node node, Object o);

    void caseStart(Start node);
    void caseAStart(AStart node);
    void caseAWithDecBody(AWithDecBody node);
    void caseAWithoutDecBody(AWithoutDecBody node);
    void caseAWithoutInstructionsBody(AWithoutInstructionsBody node);
    void caseAOpsInstructions(AOpsInstructions node);
    void caseAMultInstructionsInstructions(AMultInstructionsInstructions node);
    void caseANestedInstructions(ANestedInstructions node);
    void caseAInstructions(AInstructions node);
    void caseAIfOperation(AIfOperation node);
    void caseAWhileOperation(AWhileOperation node);
    void caseAAssignOperation(AAssignOperation node);
    void caseAPrintOperation(APrintOperation node);
    void caseAOperation(AOperation node);
    void caseAPrint(APrint node);
    void caseAAssignment(AAssignment node);
    void caseASingleDeclarations(ASingleDeclarations node);
    void caseAMultiDeclarations(AMultiDeclarations node);
    void caseABooleanType(ABooleanType node);
    void caseAIntegerType(AIntegerType node);
    void caseAComparisionExpr(AComparisionExpr node);
    void caseAExpr(AExpr node);
    void caseAPlusFoo(APlusFoo node);
    void caseAMinusFoo(AMinusFoo node);
    void caseAOrFoo(AOrFoo node);
    void caseAXorFoo(AXorFoo node);
    void caseAFoo(AFoo node);
    void caseAModWtf(AModWtf node);
    void caseAMultWtf(AMultWtf node);
    void caseADivWtf(ADivWtf node);
    void caseAAndWtf(AAndWtf node);
    void caseAWtf(AWtf node);
    void caseANotBombe(ANotBombe node);
    void caseANumberBombe(ANumberBombe node);
    void caseAIdentifierBombe(AIdentifierBombe node);
    void caseATrueBombe(ATrueBombe node);
    void caseAFalseBombe(AFalseBombe node);
    void caseAGtComparision(AGtComparision node);
    void caseAGeComparision(AGeComparision node);
    void caseALtComparision(ALtComparision node);
    void caseALeComparision(ALeComparision node);
    void caseANeComparision(ANeComparision node);
    void caseAEqComparision(AEqComparision node);
    void caseAMatchedIfexpr(AMatchedIfexpr node);
    void caseAOpenstmtIfexpr(AOpenstmtIfexpr node);
    void caseAMatchedMatchedstmt(AMatchedMatchedstmt node);
    void caseAMatchedstmt(AMatchedstmt node);
    void caseAOpenstmt(AOpenstmt node);
    void caseAElseOpenstmt(AElseOpenstmt node);
    void caseAOpsOtherInstructions(AOpsOtherInstructions node);
    void caseAMultInstructionsOtherInstructions(AMultInstructionsOtherInstructions node);
    void caseANestedOtherInstructions(ANestedOtherInstructions node);
    void caseAOtherInstructions(AOtherInstructions node);
    void caseAWhileOtherOperation(AWhileOtherOperation node);
    void caseAAssignOtherOperation(AAssignOtherOperation node);
    void caseAPrintOtherOperation(APrintOtherOperation node);
    void caseAOtherOperation(AOtherOperation node);

    void caseTInteger(TInteger node);
    void caseTBoolean(TBoolean node);
    void caseTVar(TVar node);
    void caseTNumber(TNumber node);
    void caseTAssign(TAssign node);
    void caseTBegin(TBegin node);
    void caseTProgramend(TProgramend node);
    void caseTEnd(TEnd node);
    void caseTProgram(TProgram node);
    void caseTIf(TIf node);
    void caseTThen(TThen node);
    void caseTElse(TElse node);
    void caseTWhile(TWhile node);
    void caseTDo(TDo node);
    void caseTWriteln(TWriteln node);
    void caseTBreak(TBreak node);
    void caseTLPar(TLPar node);
    void caseTRPar(TRPar node);
    void caseTPlus(TPlus node);
    void caseTMinus(TMinus node);
    void caseTMult(TMult node);
    void caseTDiv(TDiv node);
    void caseTMod(TMod node);
    void caseTEq(TEq node);
    void caseTLt(TLt node);
    void caseTGt(TGt node);
    void caseTLe(TLe node);
    void caseTGe(TGe node);
    void caseTNe(TNe node);
    void caseTAnd(TAnd node);
    void caseTOr(TOr node);
    void caseTXor(TXor node);
    void caseTNot(TNot node);
    void caseTTrue(TTrue node);
    void caseTFalse(TFalse node);
    void caseTColon(TColon node);
    void caseTSemikolon(TSemikolon node);
    void caseTDot(TDot node);
    void caseTWhitespace(TWhitespace node);
    void caseTIdentifier(TIdentifier node);
    void caseEOF(EOF node);
}

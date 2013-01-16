import analysis.DepthFirstAdapter;
import node.*;

import java.util.HashMap;
import java.util.LinkedList;

public class GraphVisitor extends DepthFirstAdapter{
    private LinkedList<Block> blocks = new LinkedList<Block>();
    private Block lastBlock;
    private Block currentBlock;
    private int blockID = 1;
    private HashMap<Integer, Integer> addSuccessors = new HashMap<Integer, Integer>();

    private LinkedList<Integer> removeSuccessors = new LinkedList<Integer>();

    /**
     * Define Def and Use in the current block
     */
    @Override
    public void caseAAssignmentExpr(AAssignmentExpr node) {
        String identifier = node.getIdentifier().toString().toLowerCase().replaceAll(" ","");
        currentBlock = new Block(identifier, blockID++);
        node.getExpr().apply(this);         // evaluate the expression
        setNextSuccessor();
    }
    /**
     * For writeln(). Nearly same as Assignment
     */
    @Override
    public void caseAPrintExpr(APrintExpr node) {
        currentBlock = new Block(blockID++);
        node.getExpr().apply(this);         // evaluate the expression
        setNextSuccessor();
    }
    /**
     * If then
     */
    @Override
    public void caseAIfThenExpr(AIfThenExpr node) {
        int temp = blockID;
        currentBlock = new Block(blockID++);
        node.getLeft().apply(this);         // evaluate the expression
        setNextSuccessor();
        node.getRight().apply(this);
        addSuccessors.put(temp, blockID);
    }
    /**
     * If then else
     */
    @Override
    public void caseAIfThenElseExpr(AIfThenElseExpr node) {
        int thenPointer, flow;     // flow = next step after ifthenelse
        int ifPointer = blockID;
        currentBlock = new Block(blockID++);
        node.getIf().apply(this);         // evaluate the expression
        setNextSuccessor();
        node.getThen().apply(this);
        thenPointer = blockID-1;                   // last element of then
        addSuccessors.put(ifPointer, blockID);
        node.getElse().apply(this);
        flow = blockID;

        // because of the normal algorithm according to setStartAndSuccessor() I need to remove the
        // first successor, because this one points to else, which is simply wrong at this point.
        removeSuccessors.add(thenPointer-1);
        addSuccessors.put(thenPointer, flow);       // Add normal program flow after the then block
    }
    /**
     * While
     */
    @Override
    public void caseAWhileExpr(AWhileExpr node) {
        int temp = blockID;
        currentBlock = new Block(blockID++);
        node.getLeft().apply(this);         // evaluate the expression
        setNextSuccessor();
        node.getRight().apply(this);
        addSuccessors.put(temp, blockID);   // Add second successor for while loop
        addSuccessors.put(blockID - 1, temp);
        removeSuccessors.add(blockID - 1);    // Remove later the first successor
    }
    /**
     * Add to the current visited block a new item to the Use list
     */
    @Override
    public void caseAIdentifierExpr(AIdentifierExpr node) {
        String identifier = node.getIdentifier().toString().toLowerCase().replaceAll(" ","");
        if (currentBlock != null) {
            if (!currentBlock.hasUse()) {
                currentBlock.addUse(identifier);
            } else {
                if (!currentBlock.getUse().contains(identifier)) {
                    currentBlock.addUse(identifier);
                }
            }
        }

    }
    public void exitNode() {
        currentBlock = new Block(blockID++);
        setNextSuccessor();
    }
    /**
     * Method to set the standard successor for one node
     */
    private void setNextSuccessor() {
        if (lastBlock != null)              // if it is the first block, do nothing
            lastBlock.addSuccessor(currentBlock);
        blocks.add(currentBlock);       // Add currentBlock to the global list of blocks
        lastBlock = currentBlock;
    }

    /************************************************************************************************/
    public HashMap<Integer, Integer> getAddSuccessors() {
        return addSuccessors;
    }
    public LinkedList<Integer> getRemoveSuccessors() {
        return removeSuccessors;
    }
    public LinkedList<Block> getBlocks() {
        return blocks;
    }

}

import java.util.HashMap;
import java.util.LinkedList;

public class Liveness {
    private GraphVisitor analysis;
    private LinkedList<Block> blocks;

    public Liveness(GraphVisitor analysis) {
        this.analysis = analysis;
        this.blocks = analysis.getBlocks();

        addSuccessors();
        removeSuccessors();

        startLiveness();
        debug();
    }

    /**
     * Preparing all the missing and unneceassary successors for the liveness analysis
     */
    private void addSuccessors() {
        // Add last successors to the blocks, which have been stored in a map
        HashMap<Integer, Integer> map = analysis.getAddSuccessors();
        int value;
        for (int key : map.keySet()) {
            value = map.get(key);
            if (value-1 < blocks.size())       // protecting to run out of the index of blocks
                blocks.get(key-1).addSuccessor(blocks.get(value-1));
        }
    }
    private void removeSuccessors() {
        for (Integer i : analysis.getRemoveSuccessors()) {
            blocks.get(i-1).getSuccessor().removeFirst();
        }
    }

    /**
     * Print all information about the blocks
     */
    private void debug() {
        System.out.println("# Evaluating Liveness...");

        Block currentBlock;

        for (int i = 0; i < blocks.size(); i++) {
            currentBlock = blocks.get(i);
            System.out.print("\t#" + currentBlock.getBlockID() + "\tDef: " + currentBlock.getDef() + "\t\tUse: " + currentBlock.getUse()+"\t\tSuccessor: ");
            if (currentBlock.hasSuccessor()) {
                for (Block block : currentBlock.getSuccessor()) {
                    System.out.print(block.getBlockID() + " ");
                }
            }
            System.out.print("\t\t IN: ");
            for (String element : currentBlock.getIn()) {
                System.out.print(element + " ");
            }
            System.out.print("\t\t OUT: ");
            for (String element : currentBlock.getOut()) {
                System.out.print(element+" ");
            }
            System.out.println();
        }
    }

    /****************************************************************************************************/
    /**
     * Start liveness analysis
     */
    private void startLiveness() {
        if (blocks.size() < Integer.MAX_VALUE) {
            Block currentBlock = blocks.getFirst();
            boolean changed = true;

            calcFirstIteration();       // Copy use to in in all the blocks!
            LinkedList<String> diff;
            LinkedList<String> inSuccessor;

            while (changed) {
                changed = false;
                for (int i = 0; i < blocks.size(); i++) {
                    // Get IN
                    diff = calcDiff(currentBlock);
                    for (String element : diff) {
                        if (!currentBlock.getIn().contains(element)) {
                            currentBlock.addIn(element);
                            changed = true;
                        }
                    }
                    // Get OUT
                    inSuccessor = calcInOfSuccessor(currentBlock);
                    for (String element : inSuccessor) {
                        if (!currentBlock.getOut().contains(element)) {
                            currentBlock.addOut(element);
                            changed = true;
                        }
                    }
                    currentBlock = blocks.get(i);
                }
            }
        }
    }

    private void calcFirstIteration() {
        for (Block block : blocks) {
            if (block.hasUse()) {
                for (String element : block.getUse()) {
                    block.addIn(element);
                }
            }
        }
    }
    private LinkedList<String> calcDiff(Block currentBlock) {
        LinkedList<String> output = new LinkedList<String>();
        boolean duplicate = false;
        for (String out : currentBlock.getOut()) {
            if (out.equals(currentBlock.getDef())) {
                duplicate = true;
            }
            if (!duplicate) {
                output.add(out);
                duplicate = false;
            }
        }
        return output;
    }
    private LinkedList<String> calcInOfSuccessor(Block currentBlock) {
        LinkedList<String> inSuccessor = new LinkedList<String>();
        if (currentBlock.hasSuccessor()) {
            for (Block successor : currentBlock.getSuccessor()) {
                for (String element : successor.getIn()) {
                    inSuccessor.add(element);
                }
            }
        }
        return inSuccessor;
    }

    private void printAdjacencyMatrix() {

    }
}

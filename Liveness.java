/**
 * Evaluating the information, I stored about IN and OUT.
 */

import java.util.HashMap;
import java.util.LinkedList;

public class Liveness {
    private GraphVisitor analysis;
    private TypeChecker typeChecker;
    private LinkedList<Block> blocks;

    /**
     * Constructor for the Liveness analysis. Copy first all results from the former graph visitors
     * and evaluate all the results
     */
    public Liveness(GraphVisitor analysis, TypeChecker typeChecker) {
        this.analysis = analysis;
        this.blocks = analysis.getBlocks();
        this.analysis.exitNode();
        this.typeChecker = typeChecker;

        addSuccessors();
        removeSuccessors();

        startLiveness();
//        debug();

        evaluateLiveness();
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
        for (Integer i : analysis.getRemoveSuccessors())
            blocks.get(i-1).getSuccessor().removeFirst();
    }

    /**
     * Print all information about the blocks
     */
    private void debug() {
        System.out.println("# Evaluating Liveness...");

        Block currentBlock;

        for (Block block : blocks) {
            currentBlock = block;
            System.out.print("\t#" + currentBlock.getBlockID() + "\tDef: " + currentBlock.getDef() + "\t\tUse: " + currentBlock.getUse() + "\t\tSuccessor: ");

            if (currentBlock.hasSuccessor())
                for (Block element : currentBlock.getSuccessor())
                    System.out.print(element.getBlockID() + " ");

            System.out.print("\t\t IN: ");
            for (String element : currentBlock.getIn())
                System.out.print(element + " ");

            System.out.print("\t\t OUT: ");
            for (String element : currentBlock.getOut())
                System.out.print(element + " ");

            System.out.println();
        }
    }

    /****************************************************************************************************/
    /**
     * Start liveness analysis like in our course
     */
    private void startLiveness() {
        if (blocks.size() < Integer.MAX_VALUE) {
            Block currentBlock = blocks.getFirst();
            boolean changed = true;

            calcFirstIteration();       // Copy USE to IN in all the blocks!
            LinkedList<String> diff;
            LinkedList<String> inSuccessor;

            while (changed) {
                changed = false;
                for (Block block : blocks) {
                    // Get IN
                    diff = calcDiff(currentBlock);
                    for (String element : diff)
                        if (!currentBlock.getIn().contains(element)) {
                            currentBlock.addIn(element);
                            changed = true;
                        }
                    // Get OUT
                    inSuccessor = calcInOfSuccessor(currentBlock);
                    for (String element : inSuccessor)
                        if (!currentBlock.getOut().contains(element)) {
                            currentBlock.addOut(element);
                            changed = true;
                        }
                    currentBlock = block;
                }
            }
        }
    }

    /**
     * Copy USE to IN of each Block. First step of algorithm.
     */
    private void calcFirstIteration() {
        for (Block block : blocks)
            if (block.hasUse())
                for (String element : block.getUse())
                    block.addIn(element);
    }

    /**
     * Calculate OUT[n] - DEF[n]
     */
    private LinkedList<String> calcDiff(Block currentBlock) {
        LinkedList<String> output = new LinkedList<String>();
        boolean duplicate = false;
        for (String out : currentBlock.getOut()) {
            if (out.equals(currentBlock.getDef()))
                duplicate = true;
            if (!duplicate) {
                output.add(out);
                duplicate = false;
            }
        }
        return output;
    }
    private LinkedList<String> calcInOfSuccessor(Block currentBlock) {
        LinkedList<String> inSuccessor = new LinkedList<String>();
        if (currentBlock.hasSuccessor())
            for (Block successor : currentBlock.getSuccessor())
                for (String element : successor.getIn())
                    inSuccessor.add(element);
        return inSuccessor;
    }

    /****************************************** Create Adjacency Matrix ******************************************/
    private void evaluateLiveness() {
        int registers = calcMaximum();
        System.out.println("Registers: "+registers);
        if (registers != 0)
            createAdjacencyMatrix();    // if it is zero, there are no variables
    }

    /**
     * Calculate maximum of all the OUTs to get the number of registers needed
     */
    private int calcMaximum() {
        int max = 0;
        for (Block block : blocks)
            if (max < block.getOut().size())
                max = block.getOut().size();
        return max;
    }

    /**
     * This method creates a Node for each identifier and calls a method to add edges to
     * the other identifiers according to the liveness analysis.
     */
    private void createAdjacencyMatrix() {
        LinkedList<Nodes> nodes = new LinkedList<Nodes>();

        // Make a new Node for all identifier found by the typeChecker
        for (String element : typeChecker.getSymbolTable().keySet())
            nodes.add(new Nodes(element));

        // Add edges to those Nodes
        createEdges(nodes);

        // Print those Edges
        System.out.println();
        for (Nodes node : nodes)
            System.out.println("ID " + node.getIdentifier() + " -> " + node.getEdge());
        System.out.println();
        System.out.println("How to read it: ID x has edges to (->) all the IDs in Brackets.\n");
    }

    /**
     * Creates an edge for all identifiers in conflict
     */
    private void createEdges(LinkedList<Nodes> nodes) {
        Nodes node;
        // find for each block
        for (Block block : blocks)
            for (String element : block.getOut()) {     // those variables in OUT
                node = nodes.get(findNode(element, nodes));     // set current node
                // and add new edges to node
                for (String addOut : block.getOut())
                    if (!node.getEdge().contains(addOut) && !node.getIdentifier().equals(addOut))
                        node.addEdge(addOut);
            }
    }

    private int findNode(String element, LinkedList<Nodes> nodes) {
        int i = 0;
        for (Nodes node : nodes)
            if (node.getIdentifier().equals(element))
                return i;
            else
                i++;
        return -1;
    }
}

/**
 * Structure for the liveness analysis. Here are the information about DEF, USE, IN and OUT stored
 */

import java.util.LinkedList;

public class Block {
    private String def;
    public LinkedList<String> use;
    private LinkedList<String> in = new LinkedList<String>();
    private LinkedList<String> out = new LinkedList<String>();
    private LinkedList<Block> successor;
    private boolean hasSuccessor = false;

    private boolean hasUse = false;
    protected int blockID;

    public Block(String identifier, int blockID) {       // for an assignment context
        this.blockID = blockID;
        this.def = identifier;
    }
    public Block(int blockID) {
        this.blockID = blockID;
    }

    ////////////////////////////////////////////////////////////////////////////////

    public void addUse(String input) {
        if (!hasUse) {
            use = new LinkedList<String>();
            hasUse = true;
        }
        use.add(input);
    }
    public void addIn(String input) {
        in.add(input);
    }
    public void addOut(String input) {
        out.add(input);
    }
    public void addSuccessor(Block input) {
        if (!hasSuccessor) {
            successor = new LinkedList<Block>();
            hasSuccessor = true;
        }
        successor.add(input);
    }

    ////////////////////////////////////////////////////////////////////////////////

    public LinkedList<String> getUse() {
        return use;
    }
    public LinkedList<String> getIn() {
        return in;
    }
    public LinkedList<String> getOut() {
        return out;
    }
    public LinkedList<Block> getSuccessor() {
        return successor;
    }
    public String getDef() {
        return def;
    }
    public boolean hasSuccessor() {
        return hasSuccessor;
    }
    public int getBlockID() {
        return blockID;
    }
    public boolean hasUse() {
        return hasUse;
    }
}

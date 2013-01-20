/**
 * This class is only for the special points for the graphical output of the
 * adjacency list
 */

import java.util.LinkedList;

public class Nodes {
    private String identifier;
    private LinkedList<String> edge = new LinkedList<String>();

    public Nodes(String identifier) {
        this.identifier = identifier;
    }
    public void addEdge(String other) {
        edge.add(other);
    }
    public LinkedList<String> getEdge() {
        return edge;
    }
    public String getIdentifier() {
        return identifier;
    }
}

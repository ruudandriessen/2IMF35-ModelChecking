/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelchecking;

import java.util.HashSet;

/**
 *
 * @author Hein
 */
public class Node {
    private final int id;
    private final HashSet<Edge> outgoingEdges;
    
    public Node(String n) {
        this.id = Integer.parseInt(n);
        this.outgoingEdges = new HashSet();
    }
    
    public void addEdge(Edge e) {
        this.outgoingEdges.add(e);
    }
    
    public int getID() {
        return this.id;
    }
    
    public HashSet<Edge> getOutEdges() {
        return this.outgoingEdges;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!Node.class.isAssignableFrom(obj.getClass())) return false;
        final Node n = (Node) obj;
        return (this.id == n.id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id;
        return hash;
    }
    
    @Override
    public String toString() {
        return Integer.toString(this.id);
    }
}

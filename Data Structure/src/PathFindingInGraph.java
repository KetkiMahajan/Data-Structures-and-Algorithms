import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Implementation of Data Structure and Algorithms
 * Graph implementation
 * To Finding a path between source and destination using DFS
 * Created by Ketki Mahajan on 3/3/2018.
 **/
public class PathFindingInGraph {
    private HashMap<Integer, Node> nodeLookup = new HashMap<>();

    public static void main(String[] args) {
        PathFindingInGraph g = new PathFindingInGraph();
        g.nodeLookup.put(0, new Node(0));
        g.nodeLookup.put(1, new Node(1));
        g.nodeLookup.put(2, new Node(2));
        g.nodeLookup.put(3, new Node(3));

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 3);

        System.out.println(g.hasPathDFS(0, 3));
    }

    private Node getNode(int id) {
        Node n = nodeLookup.get(id);
        return n;
    }

    public void addEdge(int Source, int Destination) {
        Node s = getNode(Source);
        Node d = getNode(Destination);
        s.adList.add(d);
    }

    public boolean hasPathDFS(int Source, int Destination) {
        Node s = getNode(Source);
        Node d = getNode(Destination);

        HashSet<Integer> visited = new HashSet<Integer>();
        return hasPathDFS(s, d, visited);
    }

    private boolean hasPathDFS(Node s, Node d, HashSet<Integer> visited) {
        if (visited.contains(s.id)) {
            return false;
        }
        visited.add(s.id);
        if (s == d) {
            return true;
        }
        for (Node child : s.adList) {
            if (hasPathDFS(child, d, visited)) {
                return true;
            }
        }
        return false;
    }

    public static class Node {
        LinkedList<Node> adList = new LinkedList<Node>();
        private int id;

        private Node(int id) {
            this.id = id;
        }
    }

}

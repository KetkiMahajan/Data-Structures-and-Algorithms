/**
 * Implementation of Data Structure and Algorithms
 * Find mother vertex of Graph
 * Created by Ketki Mahajan on 3/3/2018.
 **/

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class FindMotherVertex {
    static int V = 4;
    private HashMap<Integer, Node> nodeLookup = new HashMap<>();

    public static void main(String[] args) {

        FindMotherVertex g = new FindMotherVertex();
        g.nodeLookup.put(0, new FindMotherVertex.Node(0));
        g.nodeLookup.put(1, new FindMotherVertex.Node(1));
        g.nodeLookup.put(2, new FindMotherVertex.Node(2));
        g.nodeLookup.put(3, new FindMotherVertex.Node(3));

        g.addEdge(2, 1);
        g.addEdge(2, 0);
        g.addEdge(2, 3);

        System.out.println(" Mother Vertex:" + g.findMotherV());

    }

    public int findMotherV() {

        HashSet<Integer> visited = new HashSet<>();
        int n = 0;

        for (int i = 0; i < V; i++) {
            if (!visited.contains(i)) {
                DFS(nodeLookup.get(i), visited);
                n = i;
            }
        }

        visited.clear();
        DFS(nodeLookup.get(n), visited);
        for (int i = 0; i < V; i++)
            if (!visited.contains(i))
                continue;

        return nodeLookup.get(n).id;
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

    private void DFS(Node s, HashSet<Integer> visited) {
        if (!visited.contains(s.id)) {
            visited.add(s.id);
        }
        // System.out.println(s.id + "");
        for (Node child : s.adList) {
            DFS(child, visited);
        }
    }

    public static class Node {
        LinkedList<Node> adList = new LinkedList<Node>();
        private int id;

        private Node(int id) {
            this.id = id;
        }
    }

}


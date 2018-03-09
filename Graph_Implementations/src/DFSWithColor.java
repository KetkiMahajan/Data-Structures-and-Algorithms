import java.util.HashMap;
import java.util.LinkedList;

/**
 * Implementation of Data Structure and Algorithms
 * DFS implementations with help of Color{White, Gray, Black} nodes
 * Created by Ketki Mahajan on 3/4/2018.
 **/
public class DFSWithColor {
    HashMap<Integer, Node> hm = new HashMap<>();

    public static void main(String[] args) {
        DFSWithColor g = new DFSWithColor();
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);

        g.hm.put(0, n0);
        g.hm.put(1, n1);
        g.hm.put(2, n2);

        g.addEdge(n0, n1);
        g.addEdge(n0, n2);
        g.addEdge(n1, n2);

        //g.printGraph();
        g.DFS();

    }

    private void addEdge(Node n1, Node n2) {
        n1.adjList.add(n2);
    }

    private void DFS() {
        for (int i = 0; i < hm.size(); i++) {
            hm.get(i).color = "white"; //Node not visited
        }
        for (int i = 0; i < hm.size(); i++) {
            if (hm.get(i).color.equals("white")) {
                DFS_Visited(hm.get(i));
            }
        }
    }

    private void DFS_Visited(Node node) {
        node.color = "gray"; //Node is active
        System.out.println("Visited : " + node.id);
        for (Node z : node.adjList) {
            if (z.color.equals("white")) {
                DFS_Visited(z);
            }
        }
        node.color = "black"; //Node processed
    }

    private static class Node {
        int id;
        String color = " ";
        LinkedList<Node> adjList = new LinkedList<Node>();

        private Node(int id) {
            this.id = id;
        }
    }

    /*void printGraph() {

        for (int i = 0; i <nodes ; i++) {
            for(Node z: hm.get(i).adjList){
                System.out.print(" "+ z.id);
            }
            System.out.println(" ");
        }
    }*/


}

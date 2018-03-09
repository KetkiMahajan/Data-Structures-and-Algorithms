import java.util.HashMap;
import java.util.LinkedList;

/**
 * Implementation of Data Structure and Algorithms
 * Topological sorting of Directed Graphs using DFS techniques
 * Created by Ketki Mahajan on 3/9/2018.
 **/
public class TopologicalSort {
    private static HashMap<Integer, Node> hm = new HashMap<>();

    private static int[] topSortArr;
    private static int topNum;

    private static void addEdge(Node a, Node b) {
        a.adjList.add(b);
    }

    public static void main(String[] args) {
        TopologicalSort ts = new TopologicalSort();

        Node a = new Node(0);
        Node b = new Node(1);
        Node c = new Node(2);
        Node d = new Node(3);
        Node e = new Node(4);
        Node f = new Node(5);

        hm.put(0, a);
        hm.put(1, b);
        hm.put(2, c);
        hm.put(3, d);
        hm.put(4, e);
        hm.put(5, f);

        topSortArr = new int[hm.size()];
        topNum = topSortArr.length - 1;

        addEdge(a, b);
        addEdge(b, c);
        addEdge(b, f);
        addEdge(c, e);
        addEdge(f, d);

        ts.topSortDFS();
        System.out.println("Topological Sorting of Directed Graphs: ");
        for (int i = 0; i < topSortArr.length; i++) {
            System.out.print(" " + topSortArr[i]);
        }
    }

    private void topSortDFS() {
        for (int i = 0; i < hm.size(); i++) {
            hm.get(i).color = "white";
        }
        for (int i = 0; i < hm.size(); i++) {
            if (hm.get(i).color.equals("white")) {
                DFS_topSort(hm.get(i));
            }
        }

    }

    private void DFS_topSort(Node node) {
        node.color = "gray";

        for (Node z : node.adjList) {
            if (z.color.equals("white")) {
                DFS_topSort(z);
            }
        }
        topSortArr[topNum] = node.id;
        node.topOrder = topNum;
        topNum--;
        node.color = "black"; //Node processed

    }

    private static class Node {
        int id;
        String color;
        int topOrder;
        LinkedList<Node> adjList = new LinkedList<>();

        private Node(int id) {
            this.id = id;
        }
    }

}

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Implementation of Data Structure and Algorithms
 * Given a directed graph , print all types of edges like Tree Edge, Cross Edge, Back Edge and Forward Edge
 * Created by Ketki Mahajan on 3/18/2018.
 **/
enum Colors {
    BLACK, GRAY, WHITE
}

class Node {
    int id;
    Colors color;
    int dis;
    int fin;
    Node parent;
    LinkedList<Node> adj = new LinkedList<>();

    Node(int id, String col) {
        this.id = id;
        color = Colors.WHITE;
        dis = 0;
        fin = 0;
        parent = null;
    }
}

public class TypeOfEdgeInGraph {

    private static HashMap<Integer, Node> hm = new HashMap<>();
    private static int t = 0;


    public static void main(String[] args) {

        Node n1 = new Node(0, "white");
        Node a = new Node(1, "white");
        Node b = new Node(2, "white");
        Node c = new Node(3, "white");
        Node d = new Node(4, "white");
        Node e = new Node(5, "white");
        Node f = new Node(6, "white");
        Node g = new Node(7, "white");
        Node h = new Node(8, "white");

        hm.put(0, n1);
        hm.put(1, a);
        hm.put(2, b);
        hm.put(3, c);
        hm.put(4, d);
        hm.put(5, e);
        hm.put(6, f);
        hm.put(7, g);
        hm.put(8, h);

        addEdge(a, b);
        addEdge(a, e);
        addEdge(b, c);
        addEdge(c, d);
        addEdge(f, c);
        addEdge(e, f);
        addEdge(f, g);
        addEdge(f, h);
        addEdge(d, b);
        addEdge(a, h);

        DFS();
    }

    private static void DFS() {
        for (int i = 0; i < hm.size(); i++) {
            if (hm.get(i).color.equals(Colors.WHITE)) {
                DFS_Helper(hm.get(i));
            }
        }
    }

    private static void DFS_Helper(Node node) {
        node.color = Colors.GRAY;
        node.dis = ++t;

        for (Node z : node.adj) {
            if (z.color.equals(Colors.WHITE)) {
                z.parent = node;
                System.out.println("Edge between " + node.id + " and " + z.id + " is Tree edge");
                DFS_Helper(z);
            } else if (z.color.equals(Colors.GRAY)) {
                System.out.println("Edge between " + node.id + " and " + z.id + " is Back edge");

            } else if (z.color.equals(Colors.BLACK)) {
                if (node.dis < z.dis) {
                    System.out.println("Edge between " + node.id + " and " + z.id + " is Forward edge");
                } else {
                    System.out.println("Edge between " + node.id + " and " + z.id + " is Cross edge");
                }
            }
        }
        node.fin = ++t;
        node.color = Colors.BLACK;
    }

    private static void addEdge(Node n1, Node n2) {
        n1.adj.add(n2);
    }
}

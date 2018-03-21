import java.util.HashMap;

/**
 * Implementation of Data Structure and Algorithms
 * Created by Ketki Mahajan on 3/19/2018.
 **/

public class CutVerticesAndBridges {
    private static HashMap<Integer, Node> hm = new HashMap<>();
    private static int t = 0;

    public static void main(String[] args) {

        Node a = new Node(0, "white");
        Node b = new Node(1, "white");
        Node c = new Node(2, "white");
        Node d = new Node(3, "white");
        Node e = new Node(4, "white");
        Node f = new Node(5, "white");

        hm.put(0, a);
        hm.put(1, b);
        hm.put(2, c);
        hm.put(3, d);
        hm.put(4, e);
        hm.put(5, f);

        addEdge(a, b);
        addEdge(a, d);
        addEdge(b, d);
        addEdge(b, e);
        addEdge(b, c);
        addEdge(c, f);
        addEdge(e, c);

        DFS();
        findBridges();
        findCutVertices();
    }

    /**
     * Finds the cut vertex in given Undirected Graph
     * There are two rules to find the cut Vertex
     * 1) If u is root, and has more than one child then it is a cut vertex
     * 2) If u is not a root and u has child such that c.low >= u.dis then u is cut vertex
     */
    private static void findCutVertices() {
        int count = 0;
        for (int i = 0; i < hm.size(); i++) {

            if (hm.get(i).dis == 1) {
                for (Node n : hm.get(i).adj) {
                    if (n.parent == hm.get(i)) {
                        count++;
                    }
                }
                if (count > 1) {
                    System.out.println("Cut Vertex is: " + hm.get(i).id);
                }
            } else {
                boolean cutVertex = false;
                for (Node n : hm.get(i).adj) {
                    if (n.parent == hm.get(i) && n.low >= hm.get(i).dis) {
                        cutVertex = true;
                    }
                }
                if (cutVertex) {
                    System.out.println("Cut Vertex is: " + hm.get(i).id);
                }

            }


        }
    }

    /**
     * Finds the briges in given undirected graph using following rule
     * if u.dis = u.low then there is bridge between u and u.parent
     */
    private static void findBridges() {
        for (int i = 0; i < hm.size(); i++) {
            if (hm.get(i).low == hm.get(i).dis && hm.get(i).parent != null) {
                System.out.println("Bridge is: " + hm.get(i).id + " to " + hm.get(i).parent.id);
            }
        }
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
        node.low = node.dis;

        for (Node z : node.adj) {
            if (z.color.equals(Colors.WHITE)) {
                z.parent = node;
                DFS_Helper(z);
            } else if (z.color.equals(Colors.GRAY) && node.parent != z) {
                node.low = Math.min(node.low, z.dis);

            } else if (z.color.equals(Colors.GRAY) && node.parent == z) {
                z.low = Math.min(node.low, z.low);
            }

        }
        node.fin = ++t;
        node.color = Colors.BLACK;
    }

    private static void addEdge(Node n1, Node n2) {
        n1.adj.add(n2);
        n2.adj.add(n1);
    }
}

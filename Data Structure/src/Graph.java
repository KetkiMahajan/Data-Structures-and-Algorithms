import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int V;   // No. of vertices
    private LinkedList<Integer> adjList[]; //Adjacency Lists

    //Constructor
    Graph(int v) {
        V = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        int v = 5;
        Graph g = new Graph(v);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);


        g.printGraph();
        g.BreadthFS(1);
    }

    void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u);
    }

    void printGraph() {
        for (int j = 0; j < V; j++) {
            System.out.println("Adjecency list of vertex " + j);
            System.out.print("head");

            for (Integer node : adjList[j]) {
                System.out.print("," + node);
            }
            System.out.println(" ");
        }
    }

    void BreadthFS(int s) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.println(s + " ");

            Iterator<Integer> i = adjList[s].iterator();

            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}

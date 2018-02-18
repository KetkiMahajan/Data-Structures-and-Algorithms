import java.util.LinkedList;

public class GraphConstruction {

    static void addEdge(Graph g, int u, int v) {
        g.adjList[u].addFirst(v);
        g.adjList[v].addFirst(u);
    }

    static void printGraph(Graph g) {
        for (int j = 0; j < g.V; j++) {
            System.out.println("Adjecency list of vertex " + j);
            System.out.print("head");

            for (Integer node : g.adjList[j]) {
                System.out.print("," + node);
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        int v = 5;
        Graph graph = new Graph(v);
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 4);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);

        printGraph(graph);
    }

    static class Graph {
        int V;
        LinkedList<Integer> adjList[];

        Graph(int v) {
            this.V = v;
            adjList = new LinkedList[V];
            for (int i = 0; i < v; i++) {
                adjList[i] = new LinkedList<>();
            }
        }
    }
}

/**
 * Implementation of Data Structure and Algorithms
 * BFS and DFS
 * Created by Ketki Mahajan on 03/03/2018.
 **/
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int V;
    private LinkedList<Integer> adjList[];

    Graph(int v) {
        V = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }
    void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u);
    }

    public static void main(String[] args) {
        int v = 5;
        Graph g = new Graph(v);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        g.printGraph();
        System.out.println("BFS : ");
        g.BreadthFS(1);
        System.out.println(" ");
        System.out.println("DFS : ");
        g.DFS(1);
    }

    void printGraph() {
        for (int j = 0; j < V; j++) {
            // System.out.println("Adjecency list of vertex " + j);
            // System.out.print("head");
            for (Integer node : adjList[j]) {
                //  System.out.print("," + node);
            }
        }
    }

    void BreadthFS(int s) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.remove();
            System.out.print(s + " ");
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

    void DFS(int s) {
        boolean visited[] = new boolean[V];
        DFS(s, visited);
    }

    void DFS(int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");

        Iterator<Integer> i = adjList[s].iterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFS(n, visited);
        }
    }
}

/*
Dial's Algorithm:

vertices = 5
edges = 6

0 1 2
0 3 1
1 3 2
1 2 3
3 4 4
4 2 1

Shortest distance of Vertices from Source:
0->0: 0
0->1: 2
0->2: 5
0->3: 1
0->4: 5

*/

import java.util.*;

public class DialsAlgorithm {
    static final int INF = Integer.MAX_VALUE;
    private int V;
    private ArrayList<Node> adjList[];

    public DialsAlgorithm(int vertices) {
        V = vertices;
        adjList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++)
            adjList[i] = new ArrayList<Node>();
    }

    static class Node {
        int vertex, weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public void AddEdge(int src, int dest, int weight) {
        adjList[src].add(new Node(dest, weight));
    }

    public void shortestPath(int src, int E) {
        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        ArrayList<Integer> Bucket[] = new ArrayList[E * V + 1];
        for (int i = 0; i < E * V + 1; i++)
            Bucket[i] = new ArrayList<Integer>();
        Bucket[0].add(src);
        dist[src] = 0;
        int idx = 0;
        while (true) {
            while (Bucket[idx].size() == 0 && idx < E * V)
                idx++;
            if (idx == E * V)
                break;
            int u = Bucket[idx].get(0);
            Bucket[idx].remove(0);
            for (Node i : adjList[u]) {
                int v = i.vertex;
                int weight = i.weight;
                int du = dist[u];
                int dv = dist[v];
                if (du + weight < dv) {
                    dist[v] = du + weight;
                    dv = dist[v];
                    Bucket[dv].add(0, v);
                }
            }
        }

        System.out.println("\nShortest distance of Vertices from Source: ");
        for (int i = 0; i < V; ++i)
            System.out.println(src + "->" + i + ": " + dist[i]);
    }

    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of Vertices: ");
        int vertices = sc.nextInt();
        DialsAlgorithm g = new DialsAlgorithm(vertices);
        System.out.print("Enter the no. of Edges: ");
        int edges = sc.nextInt();
        int src, dest, weight;
        System.out.println("Enter the source, destination and weight corresponding to each edge: ");
        for (int i = 0; i < edges; i++) {
            src = sc.nextInt();
            dest = sc.nextInt();
            weight = sc.nextInt();
            g.AddEdge(src, dest, weight);
        }
        g.shortestPath(0, edges);

        sc.close();
    }
}

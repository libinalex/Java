/*
vertices = 7
edges = 8
0 1
0 2
1 2
1 3
2 4
3 4
3 5
4 6

   1 -- 3 -- 5
 / |    |
0  |    |
 \ |    |
   2 -- 4 -- 6

BFS(0 as source): 0 1 2 3 4 5 6
DFS(0 as source): 0 1 2 4 3 5 6
*/

import java.util.*;

class GraphTraversal {
    private ArrayList<Integer> adjList[];
    private boolean visited[];

    // GraphTraversal creation
    GraphTraversal(int vertices) {
        adjList = new ArrayList[vertices];
        visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++)
            adjList[i] = new ArrayList<Integer>();
    }
    // Add edges
    void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src); // Undirected graph
    }

    // BFS algorithm
    void BFS(int vertex) {
        Queue<Integer> queue = new LinkedList();
        visited[vertex] = true;
        queue.add(vertex);
        while (queue.size() != 0) {
            vertex = queue.poll();
            System.out.print(vertex + " ");
            for (Integer v : adjList[vertex]) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }

    // DFS algorithm
    void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for (Integer v : adjList[vertex]) {
            if (!visited[v])
                DFS(v);
        }
    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of Vertices: ");
        int vertices = sc.nextInt();

        GraphTraversal g = new GraphTraversal(vertices);
        System.out.print("Enter the no. of Edges: ");
        int edges = sc.nextInt();
        int src, dest;
        System.out.println("Enter the source and destination corresponding to each edge: ");
        for (int i = 0; i < edges; i++) {
            src = sc.nextInt();
            dest = sc.nextInt();
            g.addEdge(src, dest);
        }

        int sourceVertex = 0;

        System.out.printf("\nBreadth First Traversal (starting from vertex %d):\n ", sourceVertex);
        g.BFS(sourceVertex);

        Arrays.fill(g.visited, false);
        
        System.out.printf("\nDepth First Traversal (starting from vertex %d):\n ", sourceVertex);
        g.DFS(sourceVertex);

        sc.close();
    }
}
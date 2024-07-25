/* 
Topological Sort:

Valid only in DAG(Directed Acyclic Graph)
If there is an edge bw u and v, then u appears before v in the linear ordering of topological sort.


#1 using DFS and Stack
#2 Kahn's Algorithm - uses in-degree and Queue


vertices = 6
edges = 7
0 3
0 2
5 0
5 2
4 2
4 1
3 1

  5   4
 / \ / \
0---2   1    
  \   /
    3

#1 using DFS:
5 4 0 2 3 1

#2 using Kahn's Algorithm:
4 5 0 3 2 1 
*/

import java.util.*;

class TopologicalSort {
    private ArrayList<Integer> adjList[];
    
    private boolean visited[];
    private int V;
    
    
    TopologicalSort(int vertices) {
        adjList = new ArrayList[vertices];
        
        visited = new boolean[vertices];
        this.V = vertices;
        for (int i = 0; i < vertices; i++)
            adjList[i] = new ArrayList<Integer>();
    }

    // Add edges
    void addEdge(int src, int dest) {
        adjList[src].add(dest);
    }

    void DFS(int node, Stack<Integer> st) {
        visited[node] = true;
        for (Integer v : adjList[node]) {
            if(!visited[v])
                DFS(v, st);
        }
        st.push(node);
    }

    void topologicalSort() {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                DFS(i, st);
        }
        while (!st.isEmpty())
            System.out.print(st.pop() + " ");
    }

    void topologicalSortKahns() {
        int[] totalIndegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int j : adjList[i])
                totalIndegree[j]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (totalIndegree[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");
            for (int i : adjList[u]) {
                totalIndegree[i]--;
                if (totalIndegree[i] == 0)
                    q.add(i);
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of Vertices: ");
        int vertices = sc.nextInt();

        TopologicalSort g = new TopologicalSort(vertices);
        System.out.print("Enter the no. of Edges: ");
        int edges = sc.nextInt();
        int src, dest;
        System.out.println("Enter the source and destination corresponding to each edge: ");
        for (int i = 0; i < edges; i++) {
            src = sc.nextInt();
            dest = sc.nextInt();
            g.addEdge(src, dest);
        }

        System.out.println("\nTopological Sort: ");
        g.topologicalSort();

        System.out.println("\nTopological sort using Kahn's Algorithm:");
        g.topologicalSortKahns();
        sc.close();
    }
}

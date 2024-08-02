import java.util.*;
/* 
1. Number of Provinces
Given an undirected graph with V vertices. 
We say two vertices u and v belong to a single province if there is a path from u to v or v to u. 
Your task is to find the number of provinces.

eg.
1--2    4--5    7
  /       /      \
 3       6        8

8 5
1 2
2 3
4 5
5 6
7 8

ans: 3

public class BFS_DFS_Problems {

    static void DFS(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        for (int i : adj.get(node)) {
            if(!visited[i])
                DFS(i, visited, adj);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(); // no. of Vertices
        int E = sc.nextInt(); // no. of Edges
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= V; i++) { // <= V for 1-based indexing. <V for 0-based indexing
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(); // source of an edge
            int v = sc.nextInt(); // destination of an edge
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V + 1]; // +1 because 1-based indexing
        int count = 0;
        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                count++;
                DFS(i, visited, adj); // could also use BFS
            }
        }

        System.out.println("No. of Provinces: " + count);
    }
}
*/

/* 
2. Bipartite Graphs
 Given an adjacency list of a graph adj of V no. of vertices having 0 based index. Check whether the graph is bipartite or not.

If we are able to colour a graph with two colours such that no adjacent nodes have the same colour, it is called a bipartite graph.

Examples:
10 10
1 2
2 3
3 4
4 5
5 6
6 7
7 8
3 9
9 10
6 10

         4--5
        /    \
1--2--3       6--7--8
        \    /
         9--10

ans: true

         Y--G
        /    \
G--Y--G       Y--G--Y
        \    /
         Y--G

eg2.
7 7
1 2
2 3
3 4
4 5
2 6
6 7
7 4
      3
    /   \
1--2     4--5
    \   /
     6-7

ans: false

      G
    /   \
G--Y     Y--G--Y
    \   /
     Y-G

Observations:
Linear Graphs with no cycles are always bi-partite
Any graph with even no of CYCLE length.
Therefore, any graph with odd no. of nodes in cycle will not be a bipartite graph
*/

// #1. Using BFS
/*
public class BFS_DFS_Problems {
    static boolean isBipartite(ArrayList<ArrayList<Integer>> adj, int[] visited, int source) {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = 0; // i am coloring the nodes as 0 and 1
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int next : adj.get(node)) {
                if (visited[next] == -1) {
                    visited[next] = 1 - visited[node]; // toggle the color for next node
                    q.add(next);
                } else if (visited[next] == visited[node])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        sc.close();

        int[] visited = new int[n+1];
        Arrays.fill(visited, -1);
        for (int i = 1; i <= n; i++) {
            if (visited[i] == -1) {
                if (!isBipartite(adj, visited, i)){
                    System.out.println("No! Given graph is not a bipartite graph");
                    return;
                }
            }
        }
        System.out.println("Yes! the given graph is a Bipartite Graph");
    }
}
*/

/* 
// using DFS
*/

public class BFS_DFS_Problems {
    static boolean isBipartite(ArrayList<ArrayList<Integer>> adj, int[] visited, int source) {
        visited[source] = 0; // i am coloring the nodes as 0 and 1
        
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int next : adj.get(node)) {
                if (visited[next] == -1) {
                    visited[next] = 1 - visited[node]; // toggle the color for next node
                    q.add(next);
                } else if (visited[next] == visited[node])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        sc.close();

        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1);
        for (int i = 1; i <= n; i++) {
            if (visited[i] == -1) {
                if (!isBipartite(adj, visited, i)) {
                    System.out.println("No! Given graph is not a bipartite graph");
                    return;
                }
            }
        }
        System.out.println("Yes! the given graph is a Bipartite Graph");
    }
}
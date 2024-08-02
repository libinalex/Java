import java.util.*;
/* 
1.Detect Cycle in an Undirected Graph 
Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. 

eg.

1--2    4---5    7
  /      \ /      \
 3        6        8

8 6
1 2
2 3
4 5
4 6
5 6
7 8
Output: true (4->5->6->4)



    1
   / \
  2   3--4
 / \  |  
5   6 7--8

8 7
1 2
1 3
2 5
2 6
3 4
3 7
7 8
Output: false (no cycle in given graph)

// 1. using BFS

public class DetectCycle {
    static class Pair {
        int node;
        int parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    static boolean detectCycle(int source, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(source, -1));
        visited[source] = true;
        while (!q.isEmpty()) {
            Pair element = q.poll();
            int curr = element.node;
            int parent = element.parent;
            for (int i : adj.get(curr)) {
                if (!visited[i]) {
                    q.add(new Pair(i, curr));
                    visited[i] = true;
                } else if (i != parent) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[adj.size()];
        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                boolean cycle_present = detectCycle(i, adj, visited);
                if (cycle_present) {
                    System.out.println("Yes! A cycle is present in given graph");
                    return;
                }
            }
        }
        System.out.println("No Cycle Present in given graph");
    }
}
*/
/*
// 2. Using DFS


public class DetectCycle {
    static boolean DFS(int curr, int prev, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[curr] = true;
        for (var i : adj.get(curr)) {
            if (!visited[i]) {
                if(DFS(i, curr, adj, visited)) // return true only if already got true from child, else keep on continuing with other neighbouring nodes
                    return true;
            } else if (i != prev) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        sc.close();

        boolean[] visited = new boolean[adj.size()];
        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                if (DFS(i, -1, adj, visited)) {
                    System.out.println("Yes! a cycle is present in the graph.");
                    return;
                }
            }
        }
        System.out.println("No, a cycle is not present in the given graph");
    }
}
*/

/* 
3. Detect Cycle in a Directed Graph
Given a directed graph with V vertices and E edges, check whether it contains any cycle or not. 

eg.
10 11
1 2
2 3
3 4
4 5
5 6
3 7
7 5
8 2
8 9
9 10
10 8


*/
public class DetectCycle {
    static boolean detectCycle(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] inPath) {
        visited[node] = true;
        inPath[node] = true;

        for (int i : adj.get(node)) {
            if (!visited[i]) {
                if(detectCycle(i, adj, visited, inPath))
                    return true;
            }
            else if (inPath[i]) {
                return true;
            }
        }

        inPath[node] = false;
        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
        }
        sc.close();

        boolean[] visited = new boolean[adj.size()];
        boolean[] inPath = new boolean[adj.size()];
        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                if (detectCycle(i, adj, visited, inPath)) {
                    System.out.println("Yes! a cycle is present in the graph");
                    return;
                }
            }
        }
        System.out.println("No! a cycle is not present in the graph");
    }
}
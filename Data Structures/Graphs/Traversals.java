import java.util.*;
/*
Breadth First Search(BFS)

7 8
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
BFS(6 as source): 6 4 2 3 0 1 5

class Traversals {
    static void BFS(ArrayList<ArrayList<Integer>> adj, int source) {
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");
            for (int i: adj.get(node)) {
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());
        
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int source = 6;
        System.out.println("\nThe BFS traversal of the given graph starting from node " + source +" is: ");
        BFS(adj, source);
        
        sc.close();
    }
}

*/

/* 
Depth First Search(DFS)

7 8
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

DFS(0 as source): 0 1 2 4 3 5 6

    1
   / \
  2   3--4
 / \  |  |
5   6 7--8

8 8
1 2
1 3
2 5
2 6
3 4
3 7
4 8
7 8
*/

public class Traversals {
    static void DFS_Recursion(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int i : adj.get(node)) {
            if (!visited[i])
                DFS_Recursion(i, visited, adj);
        }
    }

    static void DFS(ArrayList<ArrayList<Integer>> adj, int source) {
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[adj.size()];
        st.push(source);
        visited[source] = true;
        while (!st.isEmpty()) {
            int node = st.pop();
            System.out.print(node + " ");
            for (int i : adj.get(node)) {
                if (!visited[i]) {
                    visited[i] = true;
                    st.push(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= n; i++) {  // <= n for 1-based indexing. <n for 0-based indexing
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int source = 3;

        System.out.println("The DFS traversal of the given graph from source node " + source + " is: ");
        // DFS(adj, source);

        boolean[] visited = new boolean[adj.size()];
        DFS_Recursion(source, visited, adj);
        sc.close();
    }
}
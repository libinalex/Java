import java.util.*;

/* 
In the question, they will mention whether it is a directed or undirected graph. 
The first line contains two space-separated integers n and m denoting the number of nodes and the number of edges respectively. 
Next m lines contain two integers u and v representing an edge between u and v. 
In the case of an undirected graph if there is an edge between u and v, it means there is an edge between v and u as well. 


1---2
|   | \
|   |  5
|   | /
3---4

i/p:
5 6
1 2
1 3
3 4
2 4
2 5
4 5


After understanding the input format, let us try to understand how the graph can be stored. The two most commonly used representations for graphs are:


// Adjacency Matrix - > takes a lot of space

public class Representation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n + 1][n + 1]; // +1 because of 1-based indexing in given input
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u][v] = 1;
            graph[v][u] = 1;
        }
        
        System.out.println("The adjacency matrix of the graph is: ");
        for(int[] i: graph)
            System.out.println(Arrays.toString(i));
    }

}
*/
/*
// Adjacency Lists
public class Representation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        // initializing n+1 nodes -> for 1-based indexing
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u); // undirected graph
        }

        System.out.println("\nThe adjacency list of the graph is: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }

        System.out.println(adj);
    }
}

*/
/* 
To store a Weighted graph
5 6
1 2 2
1 3 3
2 4 1
3 4 4
2 5 6
4 5 3


// in Adjecency Matrix:
public class Representation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n + 1][n + 1]; // +1 because of 1-based indexing in given input
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u][v] = w;
            graph[v][u] = w;
        }

        System.out.println("The adjacency matrix of the weighted graph is: ");
        for (int[] i : graph)
            System.out.println(Arrays.toString(i));
    }
}
*/
/*
// In adjency List:
public class Representation {
    static class Pair { // stores the neighbouring nodes and corresponding weight
        int v;
        int wt;

        Pair(int v, int wt){
            this.v = v;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Pair>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int wt = sc.nextInt();
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j).v + "(" + adj.get(i).get(j).wt + ") ");
            }
            System.out.println();
        }

        sc.close();
    }
}
*/


// Convert an adjacency matrix to adjacency list

public class Representation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data for adj matrix");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n + 1][n + 1]; // +1 because of 1-based indexing in given input
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        // here graph[][] is an adjacency matrix

        
        ArrayList<ArrayList<Integer>> adjMatrix = new ArrayList<ArrayList<Integer>>();
        System.out.println("Enter data for adj Matrix: ");
        int V = sc.nextInt();
        int E = sc.nextInt();
        for (int i = 1; i <= V; i++) {
            adjMatrix.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjMatrix.get(u).get(v).add(1);
            adjMatrix.get(v).get(u).add(1);
        }

        // here adjMatrix is also an adjacency Matrix
        


        // Creating new adj List for conversion of adj Matrix to adj List
        ArrayList<ArrayList<Integer>> adjList1 = new ArrayList<ArrayList<Integer>>();
        for (int i = 1; i <= V; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        // Converting graph[][] to adj List:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1 && i != j) {
                    adjList1.get(i).add(j);
                    adjList1.get(j).add(i);
                }
            }
        }


        // Creating new adj List for conversion of adj Matrix to adj List
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for (int i = 1; i <= V; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        // Converting adj Matrix to adj List
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adjMatrix.get(i).get(j) == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
    }
}
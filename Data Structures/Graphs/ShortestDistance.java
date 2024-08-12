import java.util.*;
/* 
1. Shortest distance in DAG

Given a Directed Acyclic Graph of N vertices from 0 to N-1 and a 2D Integer array(or vector) edges[ ][ ] of length M, where there is a directed edge from edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i.

Find the shortest path from src(0) vertex to all the vertices and if it is impossible to reach any vertex, then return -1 for that vertex.

Input:
N = 4, M = 2
edge = [[0,1,2],[0,2,1]]
Output:
0 2 1 -1
Explanation:
Shortest path from 0 to 1 is 0->1 with edge weight 2. 
Shortest path from 0 to 2 is 0->2 with edge weight 1.
There is no way we can reach 3, so it's -1 for 3.

Input:
N = 6, M = 7
edge = [[0,1,2],[0,4,1],[4,5,4],[4,2,2],[1,2,3],[2,3,6],[5,3,1]]
Output:
0 2 3 6 1 5
Explanation:
Shortest path from 0 to 1 is 0->1 with edge weight 2. 
Shortest path from 0 to 2 is 0->4->2 with edge weight 1+2=3.
Shortest path from 0 to 3 is 0->4->5->3 with edge weight 1+4+1=6.
Shortest path from 0 to 4 is 0->4 with edge weight 1.
Shortest path from 0 to 5 is 0->4->5 with edge weight 1+4=5.

public class ShortestDistance {
    static class Pair {
        int dest;
        int wt;

        Pair(int dest, int wt) {
            this.dest = dest;
            this.wt = wt;
        }
    }

    static void topoSort(int node, ArrayList<ArrayList<Pair>> adj, boolean[] visited, Stack<Integer> st) {
        visited[node] = true;
        for (Pair i : adj.get(node)) {
            if (!visited[i.dest]) {
                topoSort(i.dest, adj, visited, st);
            }
        }
        st.push(node);
    }

    public int[] shortestPath(int N, int M, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<Pair>());
        }

        for (int i = 0; i < M; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        }

        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                topoSort(i, adj, visited, st);
            }
        }

        int[] dist = new int[N];
        Arrays.fill(dist, (int) 1e9);
        dist[0] = 0;
        while (!st.isEmpty()) {
            int node = st.pop();
            for (Pair p : adj.get(node)) {
                int v = p.dest;
                int w = p.wt;

                if (dist[node] + w < dist[v]) {
                    dist[v] = w + dist[node];
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == (int) 1e9)
                dist[i] = -1;
        }
        return dist;
    }
}
*/

/* 
Dijkstra's Algorithm
Shortest path 
no -ve edge allowed

6 8
0 1 4
1 2 2
0 2 4
2 3 3
3 5 2
2 4 1
4 5 3
2 5 6

// Using Priority Queue:


public class ShortestDistance {
    static class GraphNode {
        int dest;
        int wt;

        GraphNode(int dest, int wt) {
            this.dest = dest;
            this.wt = wt;
        }
    }

    static class Pair {
        int node;
        int distance;

        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    static void shortestPath(ArrayList<ArrayList<GraphNode>> adj, int[] distances, int source) {
        // min heap - stores node and its distance from source, gives node with minimum distance each time
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        Arrays.fill(distances, (int)1e9);
        distances[source] = 0;
        pq.offer(new Pair(source, 0));

        while (!pq.isEmpty()) {
            System.out.println(pq);
            System.out.println(Arrays.toString(distances));
            Pair p = pq.poll();
            int node = p.node;
            int dist = p.distance;
            System.out.println("NODE, DISTANCE: " + node + " " + dist);
            for (GraphNode i : adj.get(node)) {
                int next_node = i.dest;
                int next_wt = i.wt;
                System.out.println("next node, next wt: " + next_node + " " + next_wt);
                if (dist + next_wt < distances[next_node]) {
                    System.out.println("new distance added");
                    distances[next_node] = dist + next_wt;
                    pq.offer(new Pair(next_node, dist + next_wt));
                }
            }
        }
        
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<GraphNode>> adj = new ArrayList<ArrayList<GraphNode>>();
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<GraphNode>());
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj.get(u).add(new GraphNode(v, w));
            adj.get(v).add(new GraphNode(u, w));
        }
       
        int[] distances = new int[V];
        shortestPath(adj, distances, 0);

        System.out.println(Arrays.toString(distances));
    }
}
*/
// using set:

// public class ShortestDistance {
    
//     static class Node {
//         int value;
//         int dist;

//         Node(int value, int dist) {
//             this.value = value;
//             this.dist = dist;
//         }
//     }

//     static void dijkstra(ArrayList<ArrayList<ArrayList<Integer>>> adj, int[] dist, int S) {
//         // Write your code here
//         TreeSet<Node> set = new TreeSet<Node>((node1, node2) -> {
//             if (node1.value != node2.value && node1.dist == node2.dist) {
//                 return 1;
//             }
//             return node1.dist - node2.dist;
//         });
//         set.add(new Node(S, 0));
        

//         while (!set.isEmpty()) {
//             Node node = set.pollFirst();

//             for (ArrayList<Integer> adjNodes : adj.get(node.value)) {
//                 int adjNode = adjNodes.get(0);
//                 int adjNodeDist = adjNodes.get(1);

//                 if (dist[node.value] + adjNodeDist < dist[adjNode]) {
//                     set.add(new Node(adjNode, dist[node.value] + adjNodeDist));
//                     dist[adjNode] = dist[node.value] + adjNodeDist;
//                 }
//             }
//         }
//     }

//     public static void main(String[] args) {
//         ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
//         Scanner sc = new Scanner(System.in);
//         int V = sc.nextInt();
//         int E = sc.nextInt();
//         for (int i = 0; i < V; i++) {
//             adj.add(new ArrayList<ArrayList<Integer>>());
//         }

//         for (int i = 0; i < E; i++) {
//             int u = sc.nextInt();
//             int v = sc.nextInt();
//             int w = sc.nextInt();
//             adj.get(u).add(new ArrayList(v));
//             adj.get(v).add(new ArrayList(u));
//             adj.get(u).get(v).add(w);
//             adj.get(v).get(u).add(w);
//         }

//         int[] distances = new int[V];
//         dijkstra(adj, distances, 0);

//         System.out.println(Arrays.toString(distances));
//     }
// }


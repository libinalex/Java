/*
Bellman Ford:

Sample Input:
5 8
0 1 -1
0 2 4
1 2 3
1 3 2
1 4 2
3 2 5
3 1 1
4 3 -3

Sample Output:
0 -1 2 -2 1

*/

import java.util.*;

class BellmanFord {
    static final int INF = Integer.MAX_VALUE;

    class Edge {
        int src, dest, wt;

        Edge() {
            src = dest = wt = 0;
        }
    };

    int V, E;
    Edge edges[];

    BellmanFord(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
        for (int i = 0; i < e; ++i)
            edges[i] = new Edge();
    }

    void BellmanFordDistance(int src) {
        int dist[] = new int[V];
        Arrays.fill(dist, INF);
        dist[src] = 0;
        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; j++) {
                int u = edges[j].src;
                int v = edges[j].dest;
                int wt = edges[j].wt;
                if (dist[u] != INF && dist[u] + wt < dist[v])
                    dist[v] = dist[u] + wt;
            }
        }

        // to detect if -ve weight is present:
        for (int j = 0; j < E; j++) {
            int u = edges[j].src;
            int v = edges[j].dest;
            int wt = edges[j].wt;
            if (dist[u] != INF && dist[u] + wt < dist[v]) {
                System.out.println(-1);
                return;
            }
        }

        for (int i = 0; i < V; ++i)
            if (dist[i] != INF)
                System.out.print(dist[i] + " ");
            else
                System.out.print(-1 + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        BellmanFord graph = new BellmanFord(V, E);
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph.edges[i].src = u;
            graph.edges[i].dest = v;
            graph.edges[i].wt = w;
        }
        graph.BellmanFordDistance(0);
        sc.close();
    }
}


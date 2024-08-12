import java.util.*;

class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    DisjointSet(int n) {
        for (int i = 0; i <= n; i++) { // 1-based indexing
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUParent(int node) { // finding ultimate parent ulp
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);
        if (ulp_u == ulp_v)
            return;

        if (rank.get(ulp_u) == rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);

        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);

        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);
        if (ulp_u == ulp_v)
            return;

        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
            
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

public class Disjoint_Set {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        // To check if 3 and 7 are connected(same component)
        if (ds.findUParent(3) == ds.findUParent(7)) {
            System.out.println("Yes, they are connected");
        } else {
            System.out.println("Not connected");
        }

        ds.unionBySize(3, 7);

        // If 3 and 7 are connected
        if (ds.findUParent(3) == ds.findUParent(7)) {
            System.out.println("Yes, they are connected");
        } else {
            System.out.println("Not connected");
        }

    }
}
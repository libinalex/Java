/* 
Print all nodes at a distance 'k' from a given node.

1 2 3 4 5 N 6 N 7 N N 8 9

       1            
     /   \
   2      3        
  /  \     \
 4    5     6      
  \        / \
   7      8   9  

*/

import java.util.*;


public class NodesAtDistance {
    static Node buildTree(String s) {
        String sarr[] = s.split("\\s+");
        Node root = new Node(Integer.parseInt(sarr[0]));

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < sarr.length) {
            Node currNode = q.poll();
            if (!sarr[i].equals("N")) {
                currNode.left = new Node(Integer.parseInt(sarr[i]));
                q.add(currNode.left);
            }
            i++;

            if (i >= sarr.length)
                break;

            if (!sarr[i].equals("N")) {
                currNode.right = new Node(Integer.parseInt(sarr[i]));
                q.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    
    static void printNodesAtDistanceK(Node root, Node target, int k) {
        HashMap<Node, Node> parent = new HashMap<>(); // to store a node and it's parent
        Queue<Node> q = new LinkedList<>();
        Node target_1 = null;
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node node = q.poll();
                if (node.data == target.data)
                    target_1 = node;
                if (node.left != null) {
                    q.add(node.left);
                    parent.put(node.left, node);
                }
                if (node.right != null) {
                    q.add(node.right);
                    parent.put(node.right, node);
                }
            }
        }

        // now we find nodes at k distance
        q.add(target_1);
        int dist = 0;
        boolean[] visited = new boolean[500];
        visited[target_1.data] = true;
        ArrayList<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int n = q.size();

            if (dist == k) {
                for (var i : q) {
                    ans.add(i.data);
                }
            }

            for (int i = 0; i < n; i++) {
                Node node = q.poll();
                if (node.left != null && !visited[node.left.data]) {
                    q.add(node.left);
                    visited[node.left.data] = true;
                }
                if (node.right != null && !visited[node.right.data]) {
                    q.add(node.right);
                    visited[node.right.data] = true;
                }
                Node par = parent.get(node);
                if (par != null && !visited[par.data]) {
                    q.add(par);
                    visited[par.data] = true;
                }
            }
            dist++;
        }
        for(int i: ans)
            System.out.print(i + " ");
    }

    public static void main(String[] args) {
        String s = "1 2 3 4 5 N 6 N 7 N N 8 9";
        Node root = buildTree(s);
        int k = 3;
        Node target = new Node(5);
        printNodesAtDistanceK(root, target, k);
    }
}

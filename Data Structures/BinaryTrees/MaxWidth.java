

/* 
1 2 3 -4 5 N -6 N 7 N N 8 -9

       1            
     /   \
   2      3        
  /  \     \
-4    5    -6      
  \        / \
   7      8  -9    

*/
import java.util.*;

public class MaxWidth {
    static class Pair {
        Node node;
        int ind;

        Pair(Node node, int ind) {
            this.node = node;
            this.ind = ind;
        }
    }

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

    static int maxWidthOfTree(Node root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int max = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            int mmin = q.peek().ind; // to make ind starting from 0 at each level to avoid overflow
            int first_ind = 0, last_ind = 0;
            for (int i = 0; i < n; i++) {
                Pair p = q.poll();
                Node node = p.node;
                int ind = p.ind - mmin;
                if (i == 0)
                    first_ind = ind;
                if (i == n - 1)
                    last_ind = ind;
                if (node.left != null)
                    q.add(new Pair(node.left, ind * 2 + 1));
                if (node.right != null)
                    q.add(new Pair(node.right, ind * 2 + 2));
            }
            max = Math.max(max, (last_ind - first_ind + 1));
        }
        return max;
    }
    
    public static void main(String[] args) {
        String s = "1 2 3 -4 5 N -6 N 7 N N 8 -9";
        Node root = buildTree(s);
        int maxWidth = maxWidthOfTree(root);
        System.out.println(maxWidth);
    }
}

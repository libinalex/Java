
    

    
/*
15 5 17 3 10 N 20 N N 7 12 19

        15
       /  \
     5     17
    / \      \
   3   10     20
      / \     /
     7   12  19 


*/
import java.util.*;

public class LowestCommonAncestor {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node buildTree(String s) {
        String[] sarr = s.split("\\s+");
        Node root = new Node(Integer.parseInt(sarr[0]));
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < sarr.length) {
            Node curr = q.poll();
            if (!sarr[i].equals("N")) {
                curr.left = new Node(Integer.parseInt(sarr[i]));
                q.add(curr.left);
            }
            i++;

            if (i >= sarr.length)
                return root;

            if (!sarr[i].equals("N")) {
                curr.right = new Node(Integer.parseInt(sarr[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    static int lca(Node root, int a, int b) {
        if (root.data > a && root.data > b) {
            return lca(root.left, a, b);
        }
        else if (root.data < a && root.data < b) {
            return lca(root.right, a, b);
        }
        return root.data;
    }

    public static void main(String[] args) {
        String s = "15 5 17 3 10 N 20 N N 7 12 19";
        Node root = buildTree(s);
        int a = 19;
        int b = 20;
        System.out.println("Lowest Common Ancestor of " + a + " and " + b +  " is: " + lca(root, a, b));
    }
}

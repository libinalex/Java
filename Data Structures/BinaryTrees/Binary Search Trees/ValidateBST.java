
    
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

public class ValidateBST {
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

    static void inOrderTraversal(Node root) {
        if (root == null)
            return;
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    static boolean isValidBSTUtil(Node root, int min_range, int max_range) {
        if (root == null)
            return true;
        if(root.data >=max_range || root.data <=min_range)
            return false;
        else {
            boolean leftTree = isValidBSTUtil(root.left, min_range, root.data);
            boolean rightTree = isValidBSTUtil(root.right, root.data, max_range);
            return leftTree && rightTree;
        }
    }
    
    static boolean isValidBST(Node root) {
        int max_range = Integer.MAX_VALUE;
        int min_range = Integer.MIN_VALUE;
        return isValidBSTUtil(root, min_range, max_range);
    }

    public static void main(String[] args) {
        String s = "15 5 18 3 10 N 20 N N 7 12 19";
        Node root = buildTree(s);
        System.out.println("Inorder Traversal");
        inOrderTraversal(root);

        System.out.println();
        System.out.println("Is it a valid BST? " + isValidBST(root));
    }
}

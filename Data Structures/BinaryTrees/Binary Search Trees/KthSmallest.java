
/* 
Find the kth smallest / largest element in a BST.

15 5 17 3 10 N 20 N N 7 12 19 24

     15
    /  \
  5     17
 / \      \
3   10     20
   / \     / \
  7   12  19  24

3 5 7 10 12 15 17 19 20 24

4th smallest element = 10


*/
import java.util.*;
public class KthSmallest {
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


    static int findKthSmallest(Node root, int k) {
        if(root == null) return -1;
        if(count == k) return root.data;

        findKthSmallest(root.left, k);
        count++;
        findKthSmallest(root.right, k);
        count
        return root.data;
    }

    static int findKthSmallestUtil(Node root, int k, int[] count) {

    }
    
    public static void main(String[] args) {
        String s = "15 5 17 3 10 N 20 N N 7 12 19 24";
        Node root = buildTree(s);
        System.out.println("Inorder Traversal of BST: ");
        inOrderTraversal(root);
        int k = 4;
        int kth = findKthSmallest(root, k);
        System.out.println("\n\nThe " + k + "th smallest element in BST is: " + kth);
    }
}

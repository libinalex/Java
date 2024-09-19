/* 
Converted a given sorted Array into a Height balanced Binary Search Tree.

3 5 7 10 12 15 17 19 20 24

       12
     /   \
   5       19
 /  \    /    \
3    7  15     20
      \  \      \
      10 17     24


*/

import java.util.*;

public class SortedArrayToBST {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static void levelOrderTraversal(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node node = q.poll();
                System.out.print(node.data + " ");
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            System.out.println();
        }
    }

    static void inorderTraversal(Node root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    static Node convertToBST(int[] arr, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);
        root.left = convertToBST(arr, start, mid - 1);
        root.right = convertToBST(arr, mid + 1, end);
        return root;
    }



    public static void main(String[] args) {
        int[] arr = { 3, 5, 7, 10, 12, 15, 17, 19, 20, 24 };
        Node root = convertToBST(arr, 0, arr.length-1);
        System.out.println("\nInorder Traversal: ");
        inorderTraversal(root);
        System.out.println("\nLevel-order Traversa: ");
        levelOrderTraversal(root);
    }
}

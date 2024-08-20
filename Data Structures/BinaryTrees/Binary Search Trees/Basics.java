/* 
Binary Search Tree(BST):

A BST is a Binary Tree in which, for any given node:

The left subtree of a node contains only nodes with keys less than the node’s key.
The right subtree of a node contains only nodes with keys greater than the node’s key.
Both the left and right subtrees must also be binary search trees.

10 5 15 3 8 N 20 N N 7 10

        12
       /  \
     5     15
    / \      \
   3   8      20
      / \ 
     7   10
*/

import java.util.*;

public class Basics {

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

    // 1. Searching an element in the BST
    static boolean search(Node root, int k) {
        if (root == null)
            return false;
        else if (root.data == k)
            return true;
        else if (root.data > k)
            return search(root.left, k);
        else
            return search(root.right, k);
    }

    public static void main(String[] args) {
        String s = "10 5 15 3 8 N 20 N N 7 10";
        Node root = buildTree(s);

        int k = 7;
        boolean isPresent = search(root, k);

        if (isPresent)
            System.out.println("Yes! the element " + k + " is present in the given tree.");
        else
            System.out.println("No! the element " + k + " is NOT present in the given tree.");

        
    }

}

/* 
Binary Search Tree(BST):

A BST is a Binary Tree in which, for any given node:

The left subtree of a node contains only nodes with keys less than the node’s key.
The right subtree of a node contains only nodes with keys greater than the node’s key.
Both the left and right subtrees must also be binary search trees.

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

        // // Iterative approach:
        // while (root != null && root.data != k) {
        //     root = k < root.data ? root.left : root.right;
        // }
        // return root;

        if (root == null)
            return false;
        else if (root.data == k)
            return true;
        else if (root.data > k)
            return search(root.left, k);
        else
            return search(root.right, k);
    }

    // 2. Ceil(lowest num >= key) in a BST
    static int calculateCeil(Node root, int key) {
        int ceil = -1;
        while (root != null) {
            if (root.data == key) {
                ceil = root.data;
                return ceil;
            }
            else if (root.data > key) {
                ceil = root.data;
                root = root.left;
            } else {
                root = root.right;
            }

        }
        return ceil;
    }

    // 3. Floor(greatest num <= key) in a BST
    static int calculateFloor(Node root, int key) {
        int floor = -1;
        while (root != null) {
            if (root.data == key) {
                floor = root.data;
                return floor;
            } else if (root.data > key) {
                root = root.left;
            } else {
                floor = root.data;
                root = root.right;
            }
        }
        return floor;
    }


    public static void main(String[] args) {
        String s = "15 5 17 3 10 N 20 N N 7 12 19";
        Node root = buildTree(s);

        System.out.println("Searching for an element in the BST...");
        int key = 147;
        boolean isPresent = search(root, key);
        if (isPresent)
            System.out.println("Yes! the element " + key + " is present in the given tree.");
        else
            System.out.println("No! the element " + key + " is NOT present in the given tree.");


        key = 9;
        int ceil = calculateCeil(root, key);
        System.out.println("\nThe Ceil of " + key + " in the BST is: " + ceil);
        
        key = 9;
        int floor = calculateFloor(root, key);
        System.out.println("The floor of " + key + " in the BST is: " + floor);
        
    }

}

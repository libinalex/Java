
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

public class Deletion {
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

    static void levelOrderTraversal(Node root) {
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

    static Node findLeftMax(Node root) {
        if (root.right == null)
            return root;
        return findLeftMax(root.right);
    }

    static Node helper(Node root) {
        if (root.right == null)
            return root.left;
        else if (root.left == null)
            return root.right;
        Node rightChild = root.right;
        Node leftMax = findLeftMax(root.left);
        leftMax.right = rightChild;
        return root.left;
    }

    static Node deleteNode(Node root, int key) {
        if (root == null)
            return null;
        if (root.data == key)
            return helper(root);

        Node r = root;
        while (root != null) {
            if (root.data > key) {
                if (root.left != null && root.left.data == key) {
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if (root.right != null && root.right.data == key) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return r;
    }

    static void inOrderTraversal(Node root) {
        if (root == null)
            return;
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        String s = "15 5 17 3 10 N 20 N N 7 12 19";
        Node root = buildTree(s);
        levelOrderTraversal(root);
        inOrderTraversal(root);

        System.out.println();

        int key = 17;
        Node new_root = deleteNode(root, key);
        levelOrderTraversal(new_root);
        inOrderTraversal(new_root);
    }
}

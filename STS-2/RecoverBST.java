/* 
4 2 3 1 7 5 9
      4            
    /   \
  2      3        
 / \    / \
1   7  5   9      

=> swap 7 and 3 to recover the BST

*/

import java.util.*;
class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class RecoverBST {

    static Node firstIncorrectNode = null;
    static Node secondIncorrectNode = null;
    static Node prevNode = new Node(Integer.MIN_VALUE);

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
                break;

            if (!sarr[i].equals("N")) {
                curr.right = new Node(Integer.parseInt(sarr[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    public static void recoverTree(Node root) {
        // Perform inorder traversal
        inorder(root);

        // Swap the values of the two incorrectly placed nodes
        int temp = firstIncorrectNode.val;
        firstIncorrectNode.val = secondIncorrectNode.val;
        secondIncorrectNode.val = temp;
    }

    private static void inorder(Node node) {
        if (node == null)
            return;

        inorder(node.left);

        // Check for incorrectly placed nodes
        if (firstIncorrectNode == null && prevNode.val >= node.val)
            firstIncorrectNode = prevNode;

        if (firstIncorrectNode != null && prevNode.val >= node.val)
            secondIncorrectNode = node;

        prevNode = node;

        inorder(node.right);
    }

    private static void printInorder(Node node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the nodes of the BST: ");
        String s = sc.nextLine();
        Node root = buildTree(s);
        
        System.out.println("\nInorder traversal of the BST: ");
        printInorder(root);

        recoverTree(root);

        System.out.println("\nBST after recovering: ");
        printInorder(root);

        sc.close();
    }
}
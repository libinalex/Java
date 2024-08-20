
/* 
Boundary Traversal:

Example 1:
1 2 13 4 5 N 6 N 7 N N 8 9 N N 12 15

      1            
    /   \
  2      13       
 /  \     \
4    5     6     
 \        / \
  7      8   9   
        / \
       12  15

Boundary order traversal of the tree:
1 2 4 7 5 12 15 9 6 13

*/

import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }
}

public class BoundaryTraversalTree {

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

    // print the leaves
    static void printLeaves(Node node) {
        if (node == null)
            return;

        printLeaves(node.left);
        if (node.left == null && node.right == null)
            System.out.print(node.data + " ");
        printLeaves(node.right);
    }

    // left boundary
    static void printBoundaryLeft(Node node) {
        if (node == null)
            return;
        if (node.left != null) {
            System.out.print(node.data + " ");
            printBoundaryLeft(node.left);
        } else if (node.right != null) {
            System.out.print(node.data + " ");
            printBoundaryLeft(node.right);
        }
    }

    // right boundary
    static void printBoundaryRight(Node node) {
        if (node == null)
            return;
        if (node.right != null){
            printBoundaryRight(node.right);
            System.out.print(node.data + " ");
        } else if (node.left != null) {
            printBoundaryRight(node.left);
            System.out.print(node.data + " ");
        }
    }

    static void boundaryTraversal(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        printBoundaryLeft(node.left);
        printLeaves(node);
        printBoundaryRight(node.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the nodes of the tree: ");
        String s = sc.nextLine();
        Node root = buildTree(s);

        System.out.println("Boundary order traversal of the tree: ");
        boundaryTraversal(root);

        sc.close();
    }
}

/* 
15 5 17 3 10 N 20 N N 7 12 19 24

     15
    /  \
  5     17
 / \      \
3   10     20
   / \     / \
  7   12  19  24

  
In-order Morris Traversal:
 1st case: if left is null, print current node and go right
 2nd case: before going left, make right most node on left subtree connected to current node, then go left
 3rd case: if thread is already pointed to current node, then print current node, remove the thread and move curr to right
*/
import java.util.*;

public class MorrisTraversal {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
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

    public static void inOrderTraversal(Node root) {
        Node cur = root;
        while (cur != null) {
            if (cur.left == null) {
                System.out.print(cur.data + " ");
                cur = cur.right;
            } else {
                // If the left child is not NULL, find the predecessor (rightmost node in the left subtree)
                Node prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                // If the predecessor's right child is NULL, establish a temporary link and move to the left child
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    // If the predecessor's right child is already linked, remove the link,
                    // add current node to inorder list, and move to the right child
                    prev.right = null;
                    System.out.print(cur.data + " ");
                    cur = cur.right;
                }
            }
        }
    }

    public static void preOrderTraversal(Node root) {
        Node cur = root;
        while (cur != null) {
            if (cur.left == null) {
                System.out.print(cur.data + " ");
                cur = cur.right;
            } else {
                Node prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = cur;
                    System.out.print(cur.data + " ");
                    cur = cur.left;
                } else {
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        String s = "15 5 17 3 10 N 20 N N 7 12 19 24";
        Node root = buildTree(s);
        System.out.println("Inorder Traversal: ");
        inOrderTraversal(root);
        System.out.println("\n\nPreOrder Traversal: ");
        preOrderTraversal(root);
    }
}

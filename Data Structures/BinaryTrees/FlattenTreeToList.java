
/* 
15 5 17 3 10 N 20

     15
    /  \
  5     17
 / \      \
3   10     20


Convert given Tree to a Linked List by re-arranging the nodes(preorder form):

    15
      \
       5
        \
         3
          \
           10
             \
              17
               \
                20

All left nodes pointing to null

*/
import java.util.*;

public class FlattenTreeToList {
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

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.right;
        }
    }

    static void preOrderTraversal(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // #1. Using recursive technique ( right -> left -> root traversal):
    static Node prev = null;

    static void flattenTreeToList_Recursive(Node root) {
        if (root == null)
            return;
        flattenTreeToList_Recursive(root.right);
        flattenTreeToList_Recursive(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }
    
    // #2. Iterative solution using Stack
    static void flattenTreeToList_Iterative(Node root) {
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            Node curr = st.pop();

            if (curr.right != null)
                st.push(curr.right);

            if (curr.left != null)
                st.push(curr.left);

            if (!st.isEmpty())
                curr.right = st.peek();

            curr.left = null;
        }
    }
    
    // #3. Morris Traversal - O(1) space
    static void flattenTreeToList_MorrisTraversal(Node root) {
        Node curr = root;
        while (curr != null) {
            if (curr.left != null) {
                Node prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        String s = "15 5 17 3 10 N 20 N N 7 12 19 24";
        Node root = buildTree(s);
        System.out.println("Preorder Traversal of the tree: ");
        preOrderTraversal(root);

        // System.out.println("\n\nFlattening using Recursive technique: ");
        // flattenTreeToList_Recursive(root);
        // printList(root);
        
        // System.out.println("\n\nFlattening using Iterative technique: ");
        // flattenTreeToList_Iterative(root);
        // printList(root);
        
        System.out.println("\n\nFlattening using Morris Traversal: ");
        flattenTreeToList_MorrisTraversal(root);
        printList(root);
    }
}

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

public class Insertion {
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

    static void levelOrderTraversal(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i=0; i<n; i++){
                Node node = q.poll();
                System.out.print(node.data + " ") ;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            System.out.println();

        }
    }

    public static Node insertNode(Node root, int key) {
        if (root == null)
            return null;

        Node curr = root;
        while (true) {
            if (curr.data > key) {
                if (curr.left != null)
                    curr = curr.left;
                else {
                    curr.left = new Node(key);
                    break;
                }
            }
            else {
                if (curr.right != null)
                    curr = curr.right;
                else{
                    curr.right = new Node(key);
                    break;
                }
            }
        }
        return root;
    }
    
    public static void main(String[] args) {
        String s = "15 5 17 3 10 N 20 N N 7 12 19";
        Node root = buildTree(s);
        levelOrderTraversal(root);

        int key = 18;
        Node new_root = insertNode(root, key);
        levelOrderTraversal(new_root);
    }
}

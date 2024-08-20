/* 

A tree with each node having at most 2 children is Binary tree.

Max nodes at any level i = 2^i   
Max nodes in a tree with height h = (2^h) - 1


There are 2 ways to creat a tree: 
1. using array (disjoint sets)

array:{-1, 1, 2, 3, 4, 5, -1, 6}
for any node i: 
left child at index = 2*i
right child at index = 2*i + 1


2. using nodes

Build Tree Preorder:
1 2 4 -1 -1 5 -1 -1 3 -1 6 -1 -1        // -1 represents null
 
=> Tree would look like this:

          1            -> level 0  
       /     \
     2        3        -> level 1
   /   \    /   \
  4     5  N     6     -> level 2
 / \   / \      / \
N   N  N  N    N   N

Types of traversals:
In-order: 4 2 5 1 3 6 {Left Root Right}
Pre-order: 1 2 4 5 3 6 {Root Left Right}
Post-order: 4 5 2 6 3 1 {Left Right Root}

*/

/*
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class Traversal {

    static Node createTree() {
        Scanner sc = new Scanner(System.in);
        Node root = null;
        System.out.print("Enter data: ");
        int data = sc.nextInt();
      

        if (data == -1)
            return null;

        root = new Node(data);

        System.out.println("Enter left for " + data);
        root.left = createTree();

        System.out.println("Enter right for " + data);
        root.right = createTree();

        return root;
    }
    
    static void inOrderTraversal(Node root) {

        if (root==null)
            return;

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }
    static void preOrderTraversal(Node root) {

        if (root==null)
            return;

        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    static void postOrderTraversal(Node root) {

        if (root==null)
            return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        Node root = createTree();

        System.out.print("In-order Traversal: ");
        inOrderTraversal(root);
        System.out.println();

        System.out.print("Pre-order Traversal: ");
        preOrderTraversal(root);
        System.out.println();
        
        System.out.print("Post-order Traversal: ");
        postOrderTraversal(root);
        System.out.println();
    }
}
*/

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class Traversal {

    public static Node constructTree(String s) {
        String sarr[] = s.split("\\s+");
        // String sarr[] = s.split("");
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

    // 1. In-order Traversal
    static void inOrderTraversal(Node root) {
        if (root == null)
            return;

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    // 2. Pre-order Traversal
    static void preOrderTraversal(Node root) {

        if (root == null)
            return;

        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // 3. Post-order Traversal
    static void postOrderTraversal(Node root) {

        if (root == null)
            return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }


    public static void main(String[] args){
        // your code goes here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the nodes of the tree: ");
        String str = sc.nextLine();
        Node root = constructTree(str);
        System.out.print("In-order Traversal: ");
        inOrderTraversal(root);
        System.out.println();

        System.out.print("Pre-order Traversal: ");
        preOrderTraversal(root);
        System.out.println();

        System.out.print("Post-order Traversal: ");
        postOrderTraversal(root);
        System.out.println();

        sc.close();
    }
}
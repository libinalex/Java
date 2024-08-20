
/* 

1 2 3 4 5 N 6 N 7 N N 8 9

      1           -> level 0  
    /   \
  2      3        -> level 1
 /  \     \
4    5     6      -> level 2
 \        / \
  7      8   9    -> level 3

  
*/

import java.util.*;

public class Concepts {

    // 1. Creating the Binary tree:
    public static Node constructTree(String s) {
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

    // 1. Height of a Binary Tree
    public static int height(Node node) {
        if (node == null)
            return 0;

        int left_height = height(node.left);
        int right_height = height(node.right);
        return 1 + Math.max(left_height, right_height);
    }

    // 2. Size of a Binary tree (Total no. of nodes present in it)
    public static int size(Node node) {
        if (node == null)
            return 0;

        return 1 + size(node.left) + size(node.right);
    }

    // 3. Max (or Min) node of a Binary tree
    public static int maxNode(Node node) {
        if (node == null)
            return Integer.MIN_VALUE;

        return Math.max(node.data, Math.max(maxNode(node.left), maxNode(node.right)));
    }

    // 4. Diameter of a Binary Tree (Longest Path bw 2 nodes, need not pass through root)
    static int diameter(Node root) {
        int[] max_dist = new int[1]; // to pass as reference
        diameterUtil(root, max_dist);
        return max_dist[0];
    }

    static int diameterUtil(Node node, int[] max_dist) {
        if (node == null)
            return 0;

        int left_height = diameterUtil(node.left, max_dist);
        int right_height = diameterUtil(node.right, max_dist);
        max_dist[0] = Math.max(max_dist[0], left_height + right_height);

        return 1 + Math.max(left_height, right_height);
    }
    
    // 5. To check if Binary Tree is Balanced (for all nodes, difference between left and right subtree height is not more than 1)
    static boolean isBalanced(Node root) {
        if (isBalancedUtil(root) == -1)
            return false;
        return true;
    }
    
    static int isBalancedUtil(Node node) {
        if (node == null) 
            return 0;

        int left_height = isBalancedUtil(node.left);
        int right_height = isBalancedUtil(node.right);
        if (left_height == -1 || right_height == -1)
            return -1;

        if(Math.abs(left_height - right_height) >1)
            return -1;

        return 1 + Math.max(left_height, right_height);
    }

    
    public static void main(String[] args) throws java.lang.Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the nodes of the tree: ");
        String str = sc.nextLine();

        Node root = constructTree(str);

        System.out.println("Height of the tree: " + height(root));

        System.out.println("Size of the tree: " + size(root));

        System.out.println("The maximum node of the tree is: " + maxNode(root));

        System.out.println("Diameter of the tree: " + diameter(root));

        System.out.println("Is given tree a Balanced Binary Tree?: " + isBalanced(root));


        sc.close();
    }
}


// import java.util.*;

// class practise {
//     static class Node {
//         int data;
//         Node left, right;

//         Node(int data) {
//             this.data = data;
//         }
//     }
    
//     static Node buildTree(String s) {
//         String[] str = s.split("\\s+");
//         Node root = new Node(Integer.parseInt(str[0]));
//         Queue<Node> q = new LinkedList<>();
//         q.add(root);
//         int i = 1;
//         while (!q.isEmpty() && i < str.length) {
//             Node node = q.poll();

//             if (!str[i].equals("N")) {
//                 node.left = new Node(Integer.parseInt(str[i]));
//                 q.add(node.left);
//             }
//             i++;
//             if (i >= str.length)
//                 break;

//             if (!str[i].equals("N")) {
//                 node.right = new Node(Integer.parseInt(str[i]));
//                 q.add(node.right);
//             }
//             i++;
//         }

//         return root;
//     }
    
//     static void preorderTraversal(Node root) {
//         if (root == null)
//             return;

//         System.out.print(root.data + " ");
//         preorderTraversal(root.left);
//         preorderTraversal(root.right);
//     }

//     static void inordertraversal(Node root) {
//         if (root == null)
//             return;
//         inordertraversal(root.left);
//         System.out.print(root.data + " ");
//         inordertraversal(root.right);
//     }

//     static void postorderTraversal(Node root) {
//         if (root == null)
//             return;
//         postorderTraversal(root.left);
//         postorderTraversal(root.right);
//         System.out.print(root.data + " ");
//     }

//     static void levelOrderTraversal(Node root) {
//         Queue<Node> q = new LinkedList<>();
//         q.offer(root);
//         while (!q.isEmpty()) {
//             int n = q.size();
//             for (int i = 0; i < n; i++) {
//                 Node node = q.poll();
//                 System.out.print(node.data + " ");
//                 if (node.left != null)
//                     q.add(node.left);
//                 if (node.right != null)
//                     q.add(node.right);
//             }
//             System.out.println();
//         }
//     }

//     static int maxHeight(Node root) {
//         if (root == null)
//             return -1;
//         return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
//     }

//     static void printLeftNodes(Node node) {
//         if(node == null)
//             return;
//         if (node.left != null) {
//             System.out.print(node.data + " ");
//             printLeftNodes(node.left);
//         }
//         else if (node.right != null) {
//             System.out.print(node.data + " ");
//             printLeftNodes(node.right);
//         }
//     }

//     static void printLeafNodes(Node node) {
//         if (node == null)
//            return;
//         printLeafNodes(node.left);
//         if(node.left == null && node.right == null)
//             System.out.print(node.data + " ");
//         printLeafNodes(node.right);
//     }

//     static void printRightNodes(Node node) {
//         if (node == null)
//             return;
//         if (node.right != null) {
//             printRightNodes(node.right);
//             System.out.print(node.data + " ");
//         }
//         else if (node.left != null) {
//             printRightNodes(node.left);
//             System.out.print(node.data + " ");
//         }

//     }
    
//     static void boundaryTraversal(Node root) {
//         System.out.print(root.data + " ");
//         printLeftNodes(root.left);
//         printLeafNodes(root);
//         printRightNodes(root.right);
//     }

//     static class Pair {
//         Node node;
//         int dist;

//         Pair(Node node, int dist) {
//             this.node = node;
//             this.dist = dist;
//         }
//     }

//     static void verticalTraversal(Node root) {
//         TreeMap<Integer, Node> tm = new TreeMap<>();
//         Queue<Pair> q = new LinkedList<>();
//         q.add(new Pair(root, 0));
//         while (!q.isEmpty()) {
//             Pair p = q.poll();
//             Node n = p.node;
//             int dist = p.dist;
//             tm.put(dist, n);
//             if (n.left != null) {
//                 q.add(new Pair(n.left, dist - 1));
//             }
//             if (n.right != null) {
//                 q.add(new Pair(n.right, dist + 1));
//             }
//         }

//         for (var i : tm.keySet()) {
//             System.out.print(tm.get(i).data + " ");
//         }
//     }
//     public static void main(String arg[]) {
//         String s = "2 3 4 5 6 7 8 N 9 N N 12 N N -2 7";
//         Node root = buildTree(s);
//         System.out.println("\nPre-order Traversal: ");
//         preorderTraversal(root);
//         System.out.println("\nIn-order Traversal: ");
//         inordertraversal(root);
//         System.out.println("\nPost-order Traversal: ");    
//         postorderTraversal(root);

//         System.out.println("\nLevel-order Traversal: ");
//         levelOrderTraversal(root);

//         int height = maxHeight(root);
//         System.out.println("\nMaximum height of the tree is: " + height);

//         System.out.println("Boundary Traversal");
//         boundaryTraversal(root);

//         System.out.println("\nVertical Order Traversal: ");
//         verticalTraversal(root);
//     }
// }

import java.util.*;

public class practise {

    public static void main(String[] args) {
        // ArrayList<Integer> arr = new ArrayList<>();
        // System.out.println(arr.size());
        // arr.add(2, 9);
        // arr.add(1, 9);
        HashMap<Integer, Integer> a = new HashMap<>();
        a.put(3, 4);
        System.out.println(a.get(3));
        System.out.println(a.get(4));
    }
}
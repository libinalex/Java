/* 
Vertical Order Traversal 

Example 1:
1 2 3 4 5 N 6 N 7 N N 8 9

      1           -> level 0  
    /   \
  2      3        -> level 1
 /  \     \
4    5     6      -> level 2
 \        / \
  7      8   9    -> level 3

Vertical order Traversal:  [4] [2, 7] [1, 5] [3, 8] [6] [9]
   


Example 2:
6 2 1 N 3 N 5 N 7

  6             
 / \
2   1        
 \   \
  3   5      
   \         
    7             

Vertical order Traversal: [2] [6, 3] [1, 7] [5] 
    

*/

import java.util.*;
import java.util.Map.Entry;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }
}

class VerticalTraversalTree {
    static Node build(String s[]) {
        if (s[0] == "N" || s.length == 0)
            return null;
        Node root = new Node(Integer.parseInt(s[0]));

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            Node curr = q.poll();
            if (!s[i].equals("N")) {
                curr.left = new Node(Integer.parseInt(s[i]));
                q.add(curr.left);
            }
            i++;

            if (i >= s.length)
                break;

            if (!s[i].equals("N")) {
                curr.right = new Node(Integer.parseInt(s[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    // Vertical Order Traversal
    static void verticalOrderTraversal(Node root) {
        if (root == null)
            return;
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int hd = curr.hd;
            Node temp = curr.node;

            if (map.containsKey(hd)) {
                map.get(hd).add(temp.data);
            } else {
                ArrayList<Integer> t = new ArrayList<>();
                t.add(temp.data);
                map.put(hd, t);
            }

            if (temp.left != null)
                q.add(new Pair(temp.left, hd - 1));
            if (temp.right != null)
                q.add(new Pair(temp.right, hd + 1));
        }

        for (List<Integer> values : map.values()) {
        System.out.print(values + " ");
        }
    }

    // custom class for Vertical traversal
    static class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    // main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the nodes of the tree: ");
        String s[] = sc.nextLine().split(" ");
        Node root = build(s);

        System.out.print("Vertical Order Traversal: ");
        verticalOrderTraversal(root);
        System.out.println();

        sc.close();
    }
}


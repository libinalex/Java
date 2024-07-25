/* 
Views of the Tree:

Example 1:
1 2 3 4 5 N 6 N 7 N N 8 9

      1           -> level 0  
    /   \
  2      3        -> level 1
 /  \     \
4    5     6      -> level 2
 \        / \
  7      8   9    -> level 3

Horizontal View: 1 2 3 4 5 6 7 8 9
Vertical View: 4 2 7 1 5 3 8 6 9
Right View: 1 3 6 9
Left View: 1 2 4 7
Top View: 4 2 1 3 6 9        
Bottom View: 4 7 5 8 6 9     


Example 2:
6 2 1 N 3 N 5 N 7

  6             
 / \
2   1        
 \   \
  3   5      
   \         
    7             

Horizontal View: 6 2 1 3 5 7
Vertical View: 2 6 3 1 7 5
Right View: 6 1 5 7 
Left View: 6 2 3 7 
Top View: 2 6 1 5 
Bottom View: 2 3 7 5      

*/


import java.util.*;

class Node {
    int data;      
    Node left, right;

    public Node(int data) {
        this.data = data;
    }
}

class ViewsOfTree {

    static Node build(String str) {
        String[] s = str.split("\\s+");

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
    
    // Horizontal View (Level order traversal)
    public static void horizontalView(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();

                System.out.print(node.data + " ");
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
    }

    // Left View
    static void leftView(Node root) {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node curr = queue.poll();
                if (i == 0)
                    System.out.print(curr.data + " ");
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
        }
    }

    // Right View
    static void rightView(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node curr = q.poll();
                if (i == n - 1)
                    System.out.print(curr.data + " ");
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
    }

    // custom class for Vertical, Top and Bottom view
    static class Pair {
        Node node;
        int hd; // hd -> horizontal distance from root

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    // Vertical View
    static void verticalView(Node root) {
        if (root == null)
            return;
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>(); // key-> hd, value->list of nodes with same hd. Sort acc. to hd
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

        for (ArrayList<Integer> values : map.values()) {
            System.out.print(values + " ");
        }
    }
    

    // Top View
    static void topView(Node root) {
        if (root == null)
            return;
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();    
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int hd = curr.hd;
            Node temp = curr.node;

            if (!map.containsKey(hd))
                map.put(hd, temp.data);
            if (temp.left != null)
                q.add(new Pair(temp.left, hd - 1));
            if (temp.right != null)
                q.add(new Pair(temp.right, hd + 1));
        }

        for (Integer values : map.values()) {
            System.out.print(values + " ");
        }
    }

    // Bottom View
    static void bottomView(Node root) {
        if (root == null)
            return;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int hd = curr.hd;
            Node temp = curr.node;

            map.put(hd, temp.data);
            if (temp.left != null)
                q.add(new Pair(temp.left, hd - 1));
            if (temp.right != null)
                q.add(new Pair(temp.right, hd + 1));
        }

        for (Integer value : map.values()) {
            System.out.print(value + " ");
        }
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the nodes of the tree: ");
        String str = sc.nextLine();
        Node root = build(str);

        System.out.print("Horizontal View: ");
        horizontalView(root);
        System.out.println();

        System.out.print("Vertical View: ");
        verticalView(root);
        System.out.println();

        System.out.print("Right View: ");
        rightView(root);
        System.out.println();

        System.out.print("Left View: ");
        leftView(root);
        System.out.println();

        System.out.print("Top View: ");
        topView(root);
        System.out.println();

        System.out.print("Bottom View: ");
        bottomView(root);

        sc.close();
    }
}


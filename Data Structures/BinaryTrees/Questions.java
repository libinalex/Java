
/* 
4. Level Order Traversal

void printCurrentLevel(Node node, int level) {  // O(n^2)
    if(node == null)
        return;
    
    if (level == 1) {
        print(node.data + " ");
    }
    else if (level > 1) {
        printCurrentLevel(root.left, level - 1);
        printCurrentLevel(root.right, level - 1);
    }
}

for(int i=1; i<height(root); i++){
    printCurrentLevel(root, i);
}


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

public class Questions {

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

        return 1 + Math.max(height(node.left), height(node.right));
    }

    // 2. Size of a Binary tree (total no. of nodes present in it)
    public static int size(Node node) {
        if (node == null)
            return 0;

        return size(node.left) + size(node.right) + 1;
    }

    // 3. Max (or Min) node of a Binary tree
    public static int maxNode(Node node) {
        if (node == null)
            return Integer.MIN_VALUE;

        return Math.max(node.data, Math.max(maxNode(node.left), maxNode(node.right)));
    }

    // 4. Level order Traversal
    static void printLevelOrder(Node node) { // O(n)
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.data + " ");

            if (curr.left != null)
                q.add(curr.left);

            if (curr.right != null)
                q.add(curr.right);
        }
        System.out.println();
    }

    // 4-2. Level-order traversal level-wise:
    static void printLevelOrderLevelWise(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        q.add(null);
        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr == null) {
                if (q.isEmpty()) {
                    System.out.println();
                    return;
                }

                q.add(null);
                System.out.println();
                continue;
            }

            System.out.print(curr.data + " ");

            if (curr.left != null)
                q.add(curr.left);

            if (curr.right != null)
                q.add(curr.right);
        }
    }

    // 5. Left View of the tree:
    public static void printLeftView(Node root) {
        List<Integer> list = new ArrayList();
        printLeftViewUtil(root, list, 0);
        for (int i : list)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void printLeftViewUtil(Node root, List<Integer> list, int level) {
        if (root == null) {
            return;
        }
        if (list.size() == level) {
            list.add(root.data);
        }

        printLeftViewUtil(root.left, list, level + 1);
        printLeftViewUtil(root.right, list, level + 1);

    }

    // 6. Right View of the tree:
    public static void printRightView(Node root) {
        List<Integer> list = new ArrayList();
        printRightViewUtil(root, list, 0);
        for (int i : list)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void printRightViewUtil(Node root, List<Integer> list, int level) {
        if (root == null) {
            return;
        }
        if (list.size() == level) {
            list.add(root.data);
        }

        printRightViewUtil(root.right, list, level + 1);
        printRightViewUtil(root.left, list, level + 1);

    }

    // 7. Top view of the tree
    public static void printTopView(Node root) {
        
    }

    // 8. Bottom view of the tree
    public static void printBottomView(Node root) {

    }
    
    public static void main(String[] args) throws java.lang.Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the nodes of the tree: ");
        String str = sc.nextLine();

        Node root = constructTree(str);

        System.out.println("Level order Traversal:");
        printLevelOrder(root);

        System.out.println("Level order Traversal (Level-wise):");
        printLevelOrderLevelWise(root);

        System.out.println("Height of the tree: " + height(root));

        System.out.println("Size of the tree: " + size(root));

        System.out.println("The maximum node of the tree is: " + maxNode(root));

        System.out.println("Left view of the tree: ");
        printLeftView(root);

        System.out.println("Right view of the tree: ");
        printRightView(root);

        System.out.println("Top view of the tree: ");
        printTopView(root);

        System.out.println("Bottom view of the tree: ");
        printBottomView(root);

        sc.close();
    }
}
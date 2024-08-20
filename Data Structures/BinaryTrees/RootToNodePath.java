


/* 
1 2 3 -4 5 N -6 N 7 N N 8 -9

       1            
     /   \
   2      3        
  /  \     \
-4    5    -6      
  \        / \
   7      8  -9    

max path = 5 2 1 3 -6 8 = 13

*/
import java.util.*;

public class RootToNodePath {
    
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

    static boolean rootToNodePathUtil2(Node root, Node node, ArrayList<Integer> path) {
        if (root == null)
            return false;
        path.add(root.data);
        if (root.data == node.data)
            return true;
        if(rootToNodePathUtil2(root.left, node, path) || rootToNodePathUtil2(root.right, node, path))
            return true;
        path.remove(path.size() - 1);
        return false;
    }

    static void rootToNodePathUtil(Node root, Node node, ArrayList<Integer> path) {
        if(root == null)
            return;

        path.add(root.data);

        if(root.data == node.data)
            return;

        rootToNodePathUtil(root.left, node, path);
        rootToNodePathUtil(root.right, node, path);

        if (path.get(path.size() - 1) == node.data)
            return;

        path.remove(path.size() - 1);
    }

    static void rootToNodePath(Node root, Node node) {
        ArrayList<Integer> path = new ArrayList<>();
        // rootToNodePathUtil(root, node, path);
        rootToNodePathUtil2(root, node, path);
        System.out.println(path);
    }

    public static void main(String[] args) {
        String str = "1 2 3 -4 5 N -6 N 7 N N 8 -9";

        Node root = constructTree(str);

        int n = 1;
        Node node = new Node(n);
        System.out.println("The path from root to node "+ n +" is: ");
        rootToNodePath(root, node);
    }
    
}

/* 
1 2 3 -4 5 N -6 N 7 N N 8 -9

       1            
     /   \
   2      3        
  /  \     \
-4    5    -6      
  \        / \
   7      8  -9    


*/

import java.util.*;

public class LowestCommonAncestor {
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

    static int lowestCommonAncestor(Node root, int i, int j) {
        if(root == null)
            return -1;

        if(root.data == i) 
            return i;
        if(root.data == j)
            return j;

        int left = lowestCommonAncestor(root.left, i, j);
        int right = lowestCommonAncestor(root.right, i, j);

        if (left == -1)
            return right;
        else if (right == -1)
            return left;
        else
            return root.data;
    }

    public static void main(String[] args) {
        String s = "1 2 3 -4 5 N -6 N 7 N N 8 -9";
        Node root = buildTree(s);
        int lca = lowestCommonAncestor(root, 7, 5);
        System.out.println(lca);

        System.out.println(lowestCommonAncestor(root, 8, -9));
        System.out.println(lowestCommonAncestor(root, 5, 3));
        System.out.println(lowestCommonAncestor(root, -4, -9));
    }
}

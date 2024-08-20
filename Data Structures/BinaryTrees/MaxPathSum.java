
/* 
1 2 3 -4 5 N -6 N 7 N N 8 -9

       1           - 
     /   \
   2      3        
  /  \     \
-4    5    -6      
  \        / \
   7      8  -9    

max path = 5 2 1 3 -6 8 = 13

*/
import java.util.*;

public class MaxPathSum {
    
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

    static int maxPath(Node root) {
        int[] maxi = new int[1];
        maxi[0] = Integer.MIN_VALUE;
        maxPathUtil(root, maxi);
        return maxi[0];
    }
    
    static int maxPathUtil(Node root, int[] maxi) {
        if(root == null)
            return 0;
        int left_sum = Math.max(0, maxPathUtil(root.left, maxi)); // not condsider if -ve, so 0
        int right_sum = Math.max(0, maxPathUtil(root.right, maxi));
        maxi[0] = Math.max(maxi[0], root.data + left_sum + right_sum);
        
        return root.data + Math.max(left_sum, right_sum);
    }
    public static void main(String[] args) {
        String str = "1 2 3 -4 5 N -6 N 7 N N 8 -9";

        Node root = constructTree(str);

        int maxPathSum = maxPath(root);
        System.out.println("Maximum Path sum is: " + maxPathSum);
    }
    
}

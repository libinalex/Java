
/* 
Given a binary tree with n nodes and two node values, a and b, your task is to find the minimum distance between them. 
The given two nodes are guaranteed to be in the binary tree and all node values are unique.
11 22 33 44 55 66 77

      11
    /   \
  22     33
 / \     / \
44  55  66  77




*/

import java.util.*;

public class DistanceBwNodes {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
        }
    }

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

    static int findDist(Node root, int a, int b) {
        HashMap<Node, Node> map = new HashMap<>();
        Node start = null;
        Node end = null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node node = q.poll();
                if (node.data == a)
                    start = node;
                if (node.data == b)
                    end = node;
                if (node.left != null) {
                    q.add(node.left);
                    map.put(node.left, node);
                }
                if (node.right != null) {
                    q.add(node.right);
                    map.put(node.right, node);
                }
            }
        }

        int dist = 0;
        HashMap<Node, Boolean> visited = new HashMap<>();
        q.add(start);
        visited.put(start, true);

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node node = q.poll();
                if (node == end)
                    return dist;
                if (node.left != null && visited.get(node.left) == null) {
                    q.add(node.left);
                    visited.put(node.left, true);
                }
                if (node.right != null && visited.get(node.right) == null) {
                    q.add(node.right);
                    visited.put(node.right, true);
                }
                Node par = map.get(node);
                if (par != null && visited.get(par) == null) {
                    q.add(par);
                    visited.put(par, true);
                }

            }
            dist++;
        }
        return dist;

    }
    public static void main(String[] args) {
        String s = "11 22 33 44 55 66 77";
        int a = 383;
        int b = 44;
        Node root = buildTree(s);

        int dist = findDist(root, a, b);
        System.out.println(dist);
    }
}

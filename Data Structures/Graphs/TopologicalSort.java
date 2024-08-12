import java.util.*;
/* 
Alien dictionary
Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. 
Find the order of characters in the alien language.

Input: 
N = 5, K = 4
dict = {"baa","abcd","abca","cab","cad"}
Output:
1
Explanation:
Here order of characters is 
'b', 'd', 'a', 'c' Note that words are sorted 
and in the given language "baa" comes before 
"abcd", therefore 'b' is before 'a' in output.
Similarly we can find other orders.

Input: 
N = 3, K = 3
dict = {"caa","aaa","aab"}
Output:
1
Explanation:
Here order of characters is
'c', 'a', 'b' Note that words are sorted
and in the given language "caa" comes before
"aaa", therefore 'c' is before 'a' in output.
Similarly we can find other orders.
*/

class TopologicalSort {
    static String findOrder(String[] dict, int N, int K) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int n1 = s1.length();
            int n2 = s2.length();
            int n = Math.min(n1, n2);
            for (int j = 0; j < n; j++) {
                int c1 = (int) s1.charAt(j) - 97;
                int c2 = (int) s2.charAt(j) - 97;
                if (c1 != c2) {
                    adj.get(c1).add(c2);
                    break;
                }
            }
        }

        int inDegree[] = new int[K];
        for (int i = 0; i < K; i++) {
            for (int j : adj.get(i)) {
                inDegree[j]++;
            }
        }

        System.out.println(Arrays.toString(inDegree));

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        StringBuilder s = new StringBuilder();
        while (!q.isEmpty()) {
            int node = q.poll();
            int cha = node + 97;
            char ch = (char) cha;
            s.append(ch);
            for (int i : adj.get(node)) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    q.add(i);
                }
            }
        }
        return s.toString();

    }

    public static void main(String[] args) {
        int N = 5, K = 4;
        String[] dict = { "baa", "abcd", "abca", "cab", "cad" };
        String order = findOrder(dict, N, K);
        System.out.println(order);
    }
}
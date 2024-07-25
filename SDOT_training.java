
/*

1.MERGE K SORTED LINKED LISTS

import java.util.*;
import java.lang.*;
import java.io.*;

//Name of the class has to be "Main" only if the class is public. 
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class Main {
    static Node head;

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    static Node mergeLists(Node arr[], int last) {
        // Implementing merge of two sorted linked lists
        Node result = null;
        for (int i = 0; i <= last; i++) {
            result = merge(result, arr[i]);
        }
        return result;
    }

    static Node merge(Node list1, Node list2) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (true) {
            if (list1 == null) {
                tail.next = list2;
                break;
            }
            if (list2 == null) {
                tail.next = list1;
                break;
            }

            if (list1.data <= list2.data) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) throws java.lang.Exception {
        // Accepting user input
        Scanner scn = new Scanner(System.in);

        int numLists = scn.nextInt();
        Node[] lists = new Node[numLists];

        for (int i = 0; i < numLists; i++) {
            int size = scn.nextInt();
            Node current = null;
            for (int j = 0; j < size; j++) {
                int element = scn.nextInt();
                if (current == null) {
                    current = new Node(element);
                    lists[i] = current;
                } else {
                    current.next = new Node(element);
                    current = current.next;
                }
            }
        }

        // Merging lists
        head = mergeLists(lists, numLists - 1);
        printList(head);
    }
}


--------------------------------------------------------------------------------------

2. MERGE TWO SORTED LINKED LISTS

import java.util.*;
import java.lang.*;
import java.io.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Main {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }
        
        return dummy.next;
    }
    
    public static void main (String[] args) throws java.lang.Exception{
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        ListNode l1 = createLinkedList(scanner, n);

        int m = scanner.nextInt();
        ListNode l2 = createLinkedList(scanner, m);

        ListNode merged = Main.mergeTwoLists(l1, l2);

        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
        
        scanner.close();
    }

    private static ListNode createLinkedList(Scanner scanner, int length) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int i = 0; i < length; i++) {
            int val = scanner.nextInt();
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }
}

------------------------------------------------------------------------------------------------------------

3. PALINDROME

// package whatever; // don't place package name! //

import java.util.*;
import java.lang.*;
import java.io.*;

// Name of the class has to be "Main" only if the class is public. 
class Main {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public int size;

    public Node head = null;
    public Node tail = null;

    public void addNode(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public Node reverseList(Node temp) {
        Node current = temp;
        Node prevNode = null, nextNode = null;

        while (current != null) {
            nextNode = current.next;
            current.next = prevNode;
            prevNode = current;
            current = nextNode;
        }
        return prevNode;
    }

    public void isPalindrome() {
        Node current = head;
        boolean flag = true;

        int mid = (size % 2 == 0) ? (size / 2) : ((size + 1) / 2);

        for (int i = 1; i < mid; i++) {
            current = current.next;
        }

        Node revHead = reverseList(current.next);

        while (head != null && revHead != null) {
            if (head.data != revHead.data) {
                flag = false;
                break;
            }
            head = head.next;
            revHead = revHead.next;
        }

        if (flag)
            System.out.println("true");
        else
            System.out.println("false");
    }

    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Main sList = new Main();

        Scanner scn = new Scanner(System.in);

        String input = scn.nextLine();

        String[] numbersStr = input.split("\\s+");

        for (String numStr : numbersStr) {
            int num = Integer.parseInt(numStr);
            sList.addNode(num);
        }

        sList.isPalindrome();
    }
}

-------------------------------------------------------------------------------------

4. Rubber and quiahdttw VERSE K ELEMENTS

import java.util.*;
import java.lang.*;
import java.io.*;

// Name of the class has to be "Main" only if the class is public. //
class Main {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode head = null;

    public void addNode(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode start = dummy;
        ListNode end = head;
        int count = 0;

        while (end != null) {
            count++;
            if (count % k == 0) {
                start = reverse(start, end.next);
                end = start.next;
            } else {
                end = end.next;
            }
        }
        return dummy.next;
    }

    public static ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = start;
        ListNode curr = start.next;
        ListNode first = curr;

        while (curr != end) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        start.next = prev;
        first.next = curr;
        return first;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws java.lang.Exception {
        Main sList = new Main();

        Scanner scn = new Scanner(System.in);

        String input = scn.nextLine();

        String[] numbersStr = input.split("\\s+");

        for (String numStr : numbersStr) {
            int num = Integer.parseInt(numStr);
            sList.addNode(num);
        }
        int k = scn.nextInt();

        ListNode result = reverseKGroup(sList.head, k);
        printList(result);
    }
}

-------------------------------------------------------------------------------------

5.REORDER LIST

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
    }
}

public class Main {
    static Node head = null;

    void insert(int d) {
        Node n = new Node(d);
        if (head == null) {
            head = n;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = n;
        }
    }

    static Node middle(Node h) {
        Node sp = h;
        Node fp = h;
        while (fp.next != null && fp.ne\xt.next != null) {
            sp = sp.next;
            fp = fp.next.next;
        }
        return sp;
    }

    static Node reverse(Node h) {
        Node current = h;
        Node pre = null;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    static void reorder(Node h) {
        Node mid = middle(h);
        Node k = reverse(mid.next);
        mid.next = null;
        Node c1 = h;
        Node c2 = k;
        Node f1 = null;
        Node f2 = null;
        while (c1 != null && c2 != null) {
            f1 = c1.next;
            f2 = c2.next;
            c1.next = c2;
            c2.next = f1;
            c1 = f1;
            c2 = f2;
        }
    }

    static void printlist(Node h) {
        Node current = h;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws java.lang.Exception {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String sarr[] = s.split("\\s+");
        for (int i = 0; i < sarr.length; i++) {
            m.insert(Integer.parseInt(sarr[i]));
        }
        reorder(head);
        printlist(head);
    }
}

-----------------------------------------------------------------------------------------

6. ROTATE LIST

// package whatever; // don't place package name! //

import java.util.*;
import java.lang.*;
import java.io.*;

// Name of the class has to be "Main" only if the class is public. //

class ListNode{
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
        this.next=null;
    }
}

class Main {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k = k % length;
        if (k == 0)
            return head;

        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;

        return newHead;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scn = new Scanner(System.in);

        String input = scn.nextLine();

        String[] numbersStr = input.split("\\s+");

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (String numStr : numbersStr) {
            int num = Integer.parseInt(numStr);
            current.next = new ListNode(num);
            current = current.next;
        }

        ListNode head = dummy.next;

        int k = 2;
        head = rotateRight(head, k);
        printList(head);
    }

}


-----------------------------------------------------------------------------------------

7.ODD EVEN LINKED LIST

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode evenHead = null, evenTail = null;
        ListNode oddHead = null, oddTail = null;

        ListNode current = head;

        while (current != null) {
            if (current.val % 2 == 0) { // even number
                if (evenHead == null) {
                    evenHead = current;
                    evenTail = current;
                } else {
                    evenTail.next = current;
                    evenTail = evenTail.next;
                }
            } else { // odd number
                if (oddHead == null) {
                    oddHead = current;
                    oddTail = current;
                } else {
                    oddTail.next = current;
                    oddTail = oddTail.next;
                }
            }
            current = current.next;
        }

        if (evenTail != null) {
            evenTail.next = oddHead;
        } else {
            evenHead = oddHead;
        }

        if (oddTail != null) {
            oddTail.next = null;
        }

        return evenHead;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        ListNode head = null;
        ListNode current = null;

        for (String s : input) {
            int val = Integer.parseInt(s);
            if (head == null) {
                head = new ListNode(val);
                current = head;
            } else {
                current.next = new ListNode(val);
                current = current.next;
            }
        }

        Solution solution = new Solution();
        ListNode result = solution.oddEvenList(head);
        printLinkedList(result);
        scanner.close();
    }

    private static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}



-----------------------------------------------------------------------------------------

8.LONGEST VALID PARANTHESIS

import java.util.*;

class Main {
    static int longestValidParanthesis(String s) {

        Stack<Integer> st = new Stack<>();
        int max = 0;
        st.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(i);
            } else {
                st.pop();
                if (st.isEmpty()) {
                    st.push(i);
                } else {
                    int len = i - st.peek();
                    max = Math.max(max, len);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int x = longestValidParanthesis(s);
        System.out.println(x);
    }
}--------------------------------------------------------------------------------------

9. INFIX TO POSTFIX CONVERSION
// package whatever; // don't place package name! //

import java.util.*;
import java.lang.*;
import java.io.*;

// Name of the class has to be "Main" only if the class is public. //
class Main {
    static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String in_post(String s) {
        String result = "";
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (precedence(c) > 0) {
                while (!st.isEmpty() && precedence(st.peek()) >= precedence(c)) {
                    result += st.pop();
                }
                st.push(c);
            } else if (c == ')') {
                char x = st.pop();
                while (x != '(') {
                    result += x;
                    x = st.pop();
                }
            } else if (c == '(') {
                st.push(c);
            } else {
                result += c;
            }

        }
        while (!st.isEmpty()) {
            result += st.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(in_post(s));

    }
}

-----------------------------------------------------------------------------------------

10.EVALUATE POSTFIX EXPRESSION

import java.util.*;
import java.lang.*;
import java.io.*;

// Name of the class has to be "Main" only if the class is public. //

import java.util.Stack;

class Main
{
    
    static int evaluatePostfix(String exp)
    {
       
        Stack<Integer> stack = new Stack<>();
         
        for(int i = 0; i < exp.length(); i++)
        {
            char c = exp.charAt(i);
             
            if(c == ' ')
            continue;
             
           
            else if(Character.isDigit(c))
            {
                int n = 0;
                 
                
                while(Character.isDigit(c))
                {
                    n = n*10 + (int)(c-'0');
                    i++;
                    c = exp.charAt(i);
                }
                

                stack.push(n);
            }
             
        
            else
            {
                int val1 = stack.pop();
                int val2 = stack.pop();
                 
                switch(c)
                {
                    case '+':
                    stack.push(val2+val1);
                    break;
                     
                    case '-':
                    stack.push(val2- val1);
                    break;
                     
                    case '/':
                    stack.push(val2/val1);
                    break;
                     
                    case '*':
                    stack.push(val2*val1);
                    break;
            }
            }
        }
        return stack.pop();
    }
     

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String exp = sc.nextLine();
        System.out.println(evaluatePostfix(exp));
    }
}


-------------------------------------------------------------------------------
11.BASIC CALCULATOR

import java.util.*;
import java.lang.*;
import java.io.*;

// Name of the class has to be "Main" only if the class is public. //
class Main {
    public static int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        int result = calculate(expression);
        System.out.println(result);
    }
}

--------------------------------------------------------------------------------

12.IMPLEMENT STACK USING QUEUES

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Stack {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        void push(int x) {
            q1.add(x);
        }

        int pop() {
            if (q1.isEmpty()) {
                return -1;
            }

            while (q1.size() > 1) {
                q2.add(q1.poll());
            }

            int poppedElement = q1.poll();

            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;

            return poppedElement;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack();

        int q = scanner.nextInt();

        for (int i = 0; i < q; i++) {
            int queryType = scanner.nextInt();

            if (queryType == 1) {
                int x = scanner.nextInt();
                stack.push(x);
            } else if (queryType == 2) {
                int poppedElement = stack.pop();
                System.out.println(poppedElement);
            }
        }

        scanner.close();
    }
}

------------------------------------------------------------------------------------
13. IMPLEMENT QUEUE USING STACKS

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class MyQueue {
        Queue<Integer> s1 = new LinkedList<>();
        Queue<Integer> s2 = new LinkedList<>();

        void push(int x) {
            s1.add(x);
        }

        int pop() {
            if (s2.isEmpty()) {
                if (s1.isEmpty()) {
                    return -1;
                }
                while (!s1.isEmpty()) {
                    s2.add(s1.poll());
                }
            }
            return s2.poll();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyQueue queue = new MyQueue();

        int q = scanner.nextInt();

        for (int i = 0; i < q; i++) {
            int queryType = scanner.nextInt();

            if (queryType == 1) {
                int x = scanner.nextInt();
                queue.push(x);
            } else if (queryType == 2) {
                int dequeuedElement = queue.pop();
                System.out.println(dequeuedElement);
            }
        }

        scanner.close();
    }
}

----------------------------------------------------------------------------------
14.BINARY RIGHT SIDE VIEW

import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node curr = q.poll();
                if (i == n - 1) {
                    list.add(curr.data);
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return list;
    }
}

public class Main {
    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }
        String[] ip = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < ip.length) {
            Node currNode = queue.poll();

            String currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;

            if (i >= ip.length) {
                break;
            }
            currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;

    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution tree = new Solution();
            ArrayList<Integer> arr = tree.rightView(root);
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}

---------------------------------------------------------------------------------------------------------------
15.DIAMETER OF BINARY TREE

import java.util.*;
import java.io.*;

class Main {
    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length)
                break;
            currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        Node root1 = buildTree(s1);
        Solution g = new Solution();
        System.out.println(g.diameter(root1));
    }
}

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class A {
    int ans = 0;
}

class Solution {
    static int height(Node root, A a) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left, a);
        int right = height(root.right, a);
        a.ans = Math.max(a.ans, left + right + 1);
        return 1 + Math.max(left, right);
    }

    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        A a = new A();
        height(root, a);
        return a.ans;
    }
}--------------------------------------------------------------------------------

*/

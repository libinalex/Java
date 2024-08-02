

import java.util.*;

public class practise {
    
    static void printSubsequences(int[] arr, int i) {
        if (i == arr.length) {
            System.out.println();
            return;
        }
        System.out.print(arr[i] + " ");
        printSubsequences(arr, i + 1);
        printSubsequences(arr, i);
    }

    public static void main(String args[]) {
        
        System.out.println(Math.sqrt(143)%1);
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(7);
        list.add(2);
        list.add(9);
        list.add(1);
        System.out.println(list);
        System.out.println(list.get(3));
    } 
}

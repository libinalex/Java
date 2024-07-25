
/*
1. Store the following pairs(name, age) and print in given format:

Input:
5
Aakash 21
Yash 16
Lavesh 17
Rishika 19
Harry 18

Output:
Age of Aakash is 21
Age of Yah is 16
Age of Lavesh is 17
Age of Rishika is 19
Age of Harry is 18

import java.util.*;

public class Questions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no of data: ");
        int n = sc.nextInt();
        Map<String, Integer> data = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int age = sc.nextInt();
            data.put(name, age);
        }

        for (String name : data.keySet()) {
            System.out.println("Age of " + name + " is " + data.get(name));
        }

        sc.close();
    }
}
*/

/*
// 2. Program to store contact information and display it.

import java.util.Map;
import java.util.*;

class PhoneBook {
    private Map<String, String> contacts;

    PhoneBook() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        contacts.put(name, phoneNumber);
    }

    public void displayContacts() {
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            String name = entry.getKey();
            String phoneNumber = entry.getValue();
            System.out.println("Name: " + name + ", Phone Number: " + phoneNumber);
        }
    }
}

public class Maps {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of contacts and contact details: ");
        int numContacts = sc.nextInt();
        sc.nextLine(); // to Consume the newline character

        for (int i = 0; i < numContacts; i++) {
            String name = sc.nextLine();
            String phoneNumber = sc.nextLine();
            phoneBook.addContact(name, phoneNumber);
        }

        System.out.println("\nAll Contacts:");
        phoneBook.displayContacts();
    }
}
*/

/*
3. Given an array, find the most frequent element in it. 
If there are multiple elements that appear a maximum no of times, print any one of them.

Input:
10
1 3 4 1 4 3 1 2 5 3 

Output:
1

import java.util.*;

public class Questions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int count = 1;
            int key = sc.nextInt();
            if (freq.containsKey(key))
                count = freq.get(key) + 1;

            freq.put(key, count);
        }
        System.out.println("Frequenct Map: " + freq);
        
        int max_freq = -1;
        int ansKey = -1;
        for (var key : freq.keySet()) {
            if (freq.get(key) > max_freq) {
                max_freq = freq.get(key);
                ansKey = key;
            }
        }
        System.out.println(ansKey + " has maximum frequency in the given array and occurs " + max_freq + " times.");
        sc.close();
    }
}
*/

/*
4. Valid Anagrams
Check whether two strings are anagrams of each other.
Return true if they are, else return false.
An anagram of a string is another string that contains the same characters, only the order of character can be different.
Eg. "abcd" and "dabc" are anagrams of each other

Input1:
listen
silent

Output1:
true

Input2:
anagram
grams

Output2:
false

Solution => 
- Length of both the strings should be equal.
- frequency of each character in both the strings should be equal.
- no character should be different.


import java.util.*;

public class Questions {

    static HashMap<Character, Integer> makeFrequencyMap(String str) {
        HashMap<Character, Integer> string = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int count = 1;
            if (string.containsKey(ch)) {
                count = string.get(ch) + 1;
            }
            string.put(ch, count);
        }
        return string;
    }

    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;

        HashMap<Character, Integer> string1 = makeFrequencyMap(str1);
        HashMap<Character, Integer> string2 = makeFrequencyMap(str2);
        return string1.equals(string2);
    }
    
    public static boolean isAnagram2(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        
        HashMap<Character, Integer> map = makeFrequencyMap(str1);
        for (int i = 0; i < str2.length(); i++) {
            Character ch = str2.charAt(i);
            if (map.containsKey(ch) == false)
                return false;

            int currFreq = map.get(ch);
            map.put(ch, currFreq - 1);
        }
        
        // All values in map should be 0 for str1 and str2 to be anagrams
        for (Integer i : map.values()) {
            if (i != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the two strings: ");
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println("Are the string anagrams?: " + isAnagram2(str1, str2));
        sc.close();
    }
}
*/

/*
5. Isomorphic Strings
Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurances of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character, but a character may map to itself. 

Input1:
aabcbc
xxywyw

Output1:
true

Input2:
abcdec
viouog

Output:
false


import java.util.*;

public class Questions {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Character> map = new HashMap<>();

        // for (int i = 0; i < s.length(); i++) {
        //     char ch1 = s.charAt(i);
        //     char ch2 = t.charAt(i);

        //     if (!map.containsKey(ch1)) {
        //         for (var ch : map.values()) {
        //             if (ch == ch2)
        //                 return false;
        //         }
        //         map.put(ch1, ch2);
        //     } else if (map.get(ch1) != ch2) {
        //         return false;
        //     }
        // }

        for (int i = 0; i < s.length(); i++) {
            Character sCh = s.charAt(i);
            Character tCh = t.charAt(i);

            if (map.containsKey(sCh)) {
                if (map.get(sCh) != tCh)
                    return false;
            }
            else if (map.containsValue(tCh)) {      // -> O(n), thus overall this method takes O(n^2) time complexity. TO reduce, use HashSet to add value and check 
                return false;
            }
            else {
                map.put(sCh, tCh);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the two strings: ");
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println("Are the string Isomorphic?: " + isIsomorphic(str1, str2));
        sc.close();
    }
}
*/

/* 
6. Two Sum
Given an array of length n and a target, return a pair (indices) whose sum is equal to the target.
If there is no such pair present, return -1

Input1:
n = 4
arr[] = {1, 5, 7, -1}
target = 6

Output1:
0 1

Input2:
n = 10
arr[] = {10, 12, 10, 15, -1, 7, 6, 4, 2, 1}
target = 11

Output2:
0 9

Solution => 
#1 Brute force: O(n^2)
#2 Sort the array and use binary search: O(n log(n))
#3 Use HashMap: O(n)

import java.util.*;

public class Questions {
    public static int[] targetSumBruteForce(int arr[], int t) { // O(n^2)
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == t)
                    return new int[] { i, j };
            }
        }
        return new int[] { -1 };
    }
    
    public static int[] targetSumHashMap(int[] arr, int t) {    // O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int pair = t - arr[i];
            if (map.containsKey(pair)) { // searches for pair in constant time
                return new int[] { i, map.get(pair) };
            }
            map.put(arr[i], i);
        }
        return new int[] { -1 };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of elements in array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the target: ");
        int t = sc.nextInt();

        // int result[] = targetSumBruteForce(arr, t);
        int result[] = targetSumHashMap(arr, t);

        System.out.print("The indices whose sum is equal to the target: ");
        for (int i : result) {
            System.out.print(i + " ");
        }

        sc.close();
    }
};
*/

/*
7. Largest subarray with 0 sum
Given an array of length n, find the length of the largest subarray with sum equal to 0.

Input1:
8
15 -2 2 -8 1 7 10 23

Output:
5

Input2:
3
1 2 3

Output2:
0 


import java.util.*;

public class Questions {

    public static int largestZeroSumSubarray(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max_length = 0;
        int prefix_sum = 0;
        for (int i = 0; i < arr.length; i++) {
            prefix_sum += arr[i];
            if (map.containsKey(prefix_sum)) {
                int length = i - map.get(prefix_sum);
                if (length > max_length)
                    max_length = length;
                // max_length = Math.max(max_length, i - map.get(prefix_sum));
            }
            else
                map.put(prefix_sum, i);
        }
        return max_length;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of elements in array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("The length of the largest subarray with sum equal to 0 is: " + largestZeroSumSubarray(arr));
        
        sc.close();
    }
}
*/

/*
8. 
*/
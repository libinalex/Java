
/*
char[] ch = { 'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'};
String s = new String(ch);
String s = "Hello world";
String s = new String("Hello world")

Strings are immutable in java.
*/

/* 
String Methods in java:

Method	                        Description                         	                    Return Type
charAt()        	Returns the character at the specified index (position)	                    char
codePointAt()   	Returns the Unicode of the character at the specified index	                int
codePointBefore()	Returns the Unicode of the character before the specified index	            int
codePointCount()	Returns the number of Unicode values found in a string.	                    int
compareTo()	        Compares two strings lexicographically	                                    int
compareToIgnoreCase()	Compares two strings lexicographically, ignoring case differences	    int
concat()	        Appends a string to the end of another string	                            String
contains()	        Checks whether a string contains a sequence of characters	                boolean
contentEquals()	    Checks whether a string contains the exact same sequence of characters of the specified CharSequence or StringBuffer	    boolean
copyValueOf()	    Returns a String that represents the characters of the character array	        String
endsWith()	    Checks whether a string ends with the specified character(s)	                    boolean
equals()	    Compares two strings. Returns true if the strings are equal, and false if not	    boolean
equalsIgnoreCase()	    Compares two strings, ignoring case considerations	                        boolean
format()	    Returns a formatted string using the specified locale, format string, and arguments	        String
getBytes()	    Converts a string into an array of bytes	                                                byte[]
getChars()	    Copies characters from a string to an array of chars                            	        void
hashCode()	    Returns the hash code of a string	                                                        int
indexOf()	    Returns the position of the first found occurrence of specified characters in a string	    int
intern()	    Returns the canonical representation for the string object          	                    String
isEmpty()	    Checks whether a string is empty or not	                                                    boolean
join()	        Joins one or more strings with a specified separator                	                    String
lastIndexOf()	Returns the position of the last found occurrence of specified characters in a string	    int
length()	    Returns the length of a specified string	                                                int
matches()	    Searches a string for a match against a regular expression, and returns the matches	        boolean
offsetByCodePoints()    	Returns the index within this String that is offset from the given index by codePointOffset code points	    int
regionMatches() 	Tests if two string regions are equal	                                                                            boolean
replace()	    Searches a string for a specified value, and returns a new string where the specified values are replaced	            String
replaceAll()	Replaces each substring of this string that matches the given regular expression with the given replacement         	String
replaceFirst()	Replaces the first occurrence of a substring that matches the given regular expression with the given replacement   	String
split()	        Splits a string into an array of substrings	                                                String[]
startsWith()	Checks whether a string starts with specified characters	                                boolean
subSequence()	Returns a new character sequence that is a subsequence of this sequence	                    CharSequence
substring()	    Returns a new string which is the substring of a specified string	                        String
toCharArray()	Converts this string to a new character array	                        char[]
toLowerCase()	Converts a string to lower case letters	                                String
toString()	    Returns the value of a String object	                                String
toUpperCase()	Converts a string to upper case letters	                                String
trim()	        Removes whitespace from both ends of a string	                        String
valueOf()   	Returns the string representation of the specified value            	String

IN all these methods, the original string the same as Strings are immutable
*/

/* 
StringBuilder - mutable 

Method                                                       Description
StringBuilder append(String s)                  This method appends the mentioned string with the existing string. You can also with arguments like boolean, char, int, double, float, etc.
StringBuilder insert(int offset, String s)      It will insert the mentioned string to the other string from the specified offset position. Like append, you can overload this method with arguments like (int, boolean), (int, int), (int, char), (int, double), (int, float), etc.
StringBuilder replace(int start, int end, String s)      It will replace the original string with the specified string from the start index till the end index.
StringBuilder delete(int start, int end)                 This method will delete the string from the mentioned start index till the end index.
StringBuilder reverse()                   It will reverse the string.
int capacity()                            This will show the current StringBuilder capacity.
void ensureCapacity(int min)              This method ensures that the StringBuilder capacity is at least equal to the mentioned minimum.
char charAt(int index)                    It will return the character at the specified index.
int length()                              This method is used to return the length (total characters) of the string.
String substring(int start)               Starting from the specified index till the end, this method will return the substring.
String substring(int start, int end)      It will return the substring from the start index till the end index.
int indexOf(String str)                   This method will return the index where the first instance of the specified string occurs.
int lastIndexOf(String str)               It will return the index where the specified string occurs the last.
Void trimToSize()                         It will attempt to reduce the size of the StringBuilder.
*/

/* 
public class Strings {
    public static void main(String[] args) {
        String s1 = "Libin Alex";
        String s2= "";
        System.out.println(s1.indexOf("bin"));
        System.out.println(s1.substring(2, 5));
        System.out.println(s1.substring(4));
        System.out.println(s1.contains("bin"));
        System.out.println(s1.contains("hi"));
        System.out.println(s1.toUpperCase());
        System.out.println(s2.isEmpty());

        StringBuilder s3 = new StringBuilder("Hello Libin");
        s3.append(", Hi!");
        System.out.println(s3);
        System.out.println(s3.insert(11, " Alex"));
        System.out.println(s3.delete(16, 25));
        System.out.println(s3.replace(16, 17, " Ji!"));
        System.out.println(s3.reverse());
        System.out.println(s3);
    }
}
*/

/* 
1. Check if two strings are anagrams of each other
An anagram is a literary device where the letters that make up a word, phrase, or name are rearranged to create new ones.


public class Strings {

    static boolean isAnagram(String s1, String s2) {
        int[] anagram = new int[256]; // Taking 256 size as that is the no of different possible keys in 
        
        for (int i = 0; i < s1.length(); i++) {
            anagram[s1.charAt(i)]++;
        }
        for (int i = 0; i < s1.length(); i++) {
            anagram[s2.charAt(i)]--;
        }
        for (int i : anagram) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s1 = "rescue";
        String s2 = "secure";
        System.out.println("Are the strings Anagrams?: " + isAnagram(s1, s2));
    }
}
*/

/* 
2. Reverse the words in a given string sentence.
Logic: First reverse each word, then reverse entire sentence


import java.util.Arrays;

public class Strings {

    static char[] reverseCharacters(char[] ch, int i, int j) {
        while (i < j) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
        return ch;
    }

    static String reverseWords(String s) {
        char[] ch = s.toCharArray();

        // Reversing each word in the sentence
        int start = 0;
        int end = 0;
        for (; end < ch.length; end++) {
            if (ch[end] == ' ') {
                reverseCharacters(ch, start, end - 1);
                start = end + 1;
            }
        }
        reverseCharacters(ch, start, end - 1); // Reversing the last word 
        
        // Reversing entire sentence
        reverseCharacters(ch, 0, ch.length - 1);
        return new String(ch);
    }

    public static void main(String[] args) {
        String s = "Hello I am Libin Alex";
        System.out.println(s);
        String reverse = reverseWords(s);
        System.out.println(reverse);
    }
}
*/

// Pattern Matching Algorithm (in java, could directly use contains() method)

// Naive approach - O(n.m)
/*
String: abcabdabbacdab
Pattern: bda


public class Strings {
    static void stringMatching(String s, String p) {
        int n = s.length();
        int m = p.length();
        for (int i = 0; i < n - m; i++) {
            for (int j = 0; j < m; j++) {
                if (s.charAt(i + j) != p.charAt(j))
                    break;
                if(j == m-1)
                    System.out.println("String match found at index: " + i);
            }
            
        }
    }
    public static void main(String[] args) {
        String s = "abcabdabdbacbdab";
        String p = "bda";
        stringMatching(s, p);
    }
}
*/

/* 
Rabin Karp Algorithm - O(n+m) in avg, O(n.m in worst)
Comparing hash of pattern with string, if hash matches, then compare


public class Strings {
    static void rabinKarp(String s, String p) {
        int n = s.length();
        int m = p.length();
        int hashP = 0;
        
        System.out.println("Hash of pattern: " + hashP);

        int hashS = 0;
        for (int i = 0; i < n - m; i++) {
            
        }
    }

    public static void main(String[] args) {
        String s = "abcabdabdbacbdab";
        String p = "bda";
        rabinKarp(s, p);
    }
}
*/

/* 
4. Check if strings are Rotation


public class Strings {
    static boolean isRotation(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        String s = s1 + s1;
        return s.contains(s2);
    }
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "cdba";
        System.out.println(isRotation(s1, s2));
    }
}
*/

/* 
5. Find Longest Substring with distinct characters
i/p: abcdcapbdbc
o/p: dcapb -> 5

import java.util.*;
public class Strings {
    static String longestDistinctSubstring(String s) {
        int ans = 0;
        int[] ind = new int[256]; // to store previous index of a character.
        Arrays.fill(ind, -1);
        int i = 0, j = 0;
        int i_ans = 0, j_ans = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            if (ind[ch] < i) {  // when next element is not already present in window, update its last index
                ind[ch] = j;
            }
            else {  // when next element is already present in window, change i
                i = ind[ch] + 1;
            }
            j++;

            if ((j - i) > ans) {
                ans = j - i;
                j_ans = j;
                i_ans = i;
            }
        }
        return s.substring(i_ans, j_ans);
    }
    public static void main(String[] args) {
        String s = "abcdcapbdbc";
        String ans = longestDistinctSubstring(s);
        System.out.println("The longest substring in " + s + " with distinct characters is: " + ans + " of size: " + ans.length());
    }
}
*/
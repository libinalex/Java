// Problems on Maps

/*
Develop a word count application that counts the frequency of words in a given text. 
Implement a method called countWords(String text) that takes a string parameter and 
returns a HashMap containing each unique word as the key and its frequency as the value.

Sample input: 
Java is a programming language. Java is widely used.

Output:
{Java=2, a=1, widely=1, used.=1, language=1, is=2, programming=1}
*/

import java.util.*;

public class Map_Problem {

    public static HashMap<String, Integer> countWords(String text) {
        HashMap<String, Integer> hm = new HashMap<>();
        String[] words = text.split(" ");
        for (String word : words) {
            if (hm.containsKey(word))
                hm.put(word, hm.get(word) + 1);
        
            else
                hm.put(word, 1);

            // int count = hm.getOrDefault(words, 0); -> could be used instead of if - else
            // hm.put(word, count + 1);
        }

        return hm;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text: ");
        String text = sc.nextLine();
        HashMap<String, Integer> wordCount = countWords(text);
        System.out.println(wordCount);
    }
}

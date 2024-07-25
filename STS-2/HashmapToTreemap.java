
/* 

Searching:
              Best case          Avg. case       Worst case
BST       -      O(1)            O(log N)          O(N)
AVL       -    O(log N)          O(log N)        O(log N)
Red-Black -    O(log N)          O(log N)        O(log N)

AVL trees:
- may require many rotations to balance the tree
- strictly hight balanced
- searching is faster

Red-Black trees:
- maximum of only two rotations is required to balance a tree
- roughly height balanced
- insertion and deletion is faster
 
- Self Balancing BST
- Every node is either Black or Red
- Root is always Black
- Every leaf which is Null is Black
- If a node is Red then it's children are Black 
- Every path from a node to any of its descendent Null node has same no. of Black nodes 
- path from root to farthest leaf <= 2 * path from root to nearest leaf node

A Red-Black tree need not be an AVL tree, but every AVL can be a colored to form a Red-Black tree.


TreeMap is implemented using a Red-Black Tree.
HashMap is generally faster than TreeMap for insertion, deletion, and searching, with an average-case constant time for these operations.
TreeMap, being a balanced tree structure, has logarithmic time complexity for these operations. This means that as the number of elements grows, TreeMap operations will generally take more time compared to HashMap.
TreeMap maintains a sorted order of keys
*/
/*
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashmapToTreemap {

    private static TreeMap<Integer, String> convertHashMapToTreeMap(Map<Integer, String> hashMap) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            treeMap.put(key, value);
        }
        return treeMap;
    }

    public static void main(String[] args) {
        // Creating a HashMap
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(30, "Apple");
        hashMap.put(1283, "Banana");
        hashMap.put(234, "Orange");
        hashMap.put(5, "Grapes");
        hashMap.put(296, "Watermelon");
        hashMap.put(75, "Papaya");
        hashMap.put(-36, "Orange");
        hashMap.put(0, "Mango");
        
        System.out.println("HashMap: " + hashMap);

        // Converting HashMap to TreeMap using the algorithm
        TreeMap<Integer, String> treeMap = convertHashMapToTreeMap(hashMap);

        // Printing  the TreeMap
        System.out.println("TreeMap: " + treeMap);
    }
}
*/

/* 
There are a few ways to convert HashMap to TreeMap in Java: 
1. Using vanilla Java
2. Using Collectors (valid in Java 8 and above)
3. Using Guava library
4. Manual conversion


1. Using Vanilla Java (Direct Method)

Pass HashMap instance to the TreeMap constructor OR to putAll() method. 
This will directly create the TreeMap from the HashMap

import java.util.*;

class HashmapToTreemap {
    public static <K, V> Map<K, V> convertToTreeMap(Map<K, V> hashMap)
    {
        Map<K, V> treeMap = new TreeMap<>();
        treeMap.putAll(hashMap);
        return treeMap;
    }
    public static void main(String args[])
    {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("10", "Welcome");
        hashMap.put("21", "to");
        hashMap.put("30", "Coding Class");
        System.out.println("Original HashMap: " + hashMap);
        Map<String, String> treeMap = convertToTreeMap(hashMap);
        System.out.println("TreeMap: " + treeMap);
    }
}

*/
/* 
2. Using Collectors (valid in Java 8 and above)

import java.util.*;
import java.util.stream.*;

class HashmapToTreemap {
    public static <K, V> Map<K, V> convertToTreeMap(Map<K, V> hashMap) {
        Map<K, V> treeMap = hashMap.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> newValue,
                        TreeMap::new
)
);

        return treeMap;
    }

    public static void main(String args[]) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("105", "A");
        hashMap.put("25", "B");
        hashMap.put("37", "W");
        hashMap.put("4", "X");
        hashMap.put("62", "Y");
        hashMap.put("7", "Z");

        System.out.println("HashMap: " + hashMap);

        Map<String, String> treeMap = convertToTreeMap(hashMap);

        System.out.println("TreeMap: " + treeMap);
    }
}
*/
/* 
3. Using Guava library
Guava also provides a TreeMap implementation which can be used to create an empty TreeMap instance.

*/
import java.util.*;

class HashmapToTreemap {
    public static <K extends Comparable<? super K>, V> Map<K, V> convertToTreeMap(Map<K, V> hashMap) {
        Map<K, V> treeMap = new TreeMap<>();
        treeMap.putAll(hashMap);
        return treeMap;
    }

    public static void main(String args[]) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "A");
        hashMap.put("2", "B");
        hashMap.put("4", "X");
        hashMap.put("3", "W");
        hashMap.put("6", "Y");
        hashMap.put("7", "Z");
        System.out.println("HashMap: " + hashMap);
        Map<String, String> treeMap = convertToTreeMap(hashMap);
        System.out.println("TreeMap: " + treeMap);
    }
}

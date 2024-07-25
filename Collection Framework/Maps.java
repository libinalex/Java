
/*
Map:
Does not extend collection.
map is an interface.
A Map is an object that maps keys to values -> entry(key,value)
Provides methods for storing values based on key basis.
A map cannot contain duplicate keys.
Data is accessed using keys.
Order is not maintained
Each key can map to at most one value. It models the mathematical function abstraction.
methods to iterater through the Map: keySet(), values(), entrySet()


Container object stores key/value pairs
3 Concrete Interfaces:
• HashMap -> data stord in no particular order
• LinkedHashMap -> data is stored in order of insertion
• TreeMap   -> data stored in sorted order according to key


HashMap can contain one null key, but TreeMap cannot contain null keys 

put(k, v)
get(k)
containsKey(k)
containsValue(v)
remove(k)

*/


import java.util.Map;   // to use Map.Entry
import java.util.*;

public class Maps {
    public static void main(String[] args) {
        // Hash Map
        HashMap<Integer, String> hm = new HashMap<>();

        // Adding elements:
        hm.put(1, "Mango");
        hm.put(2, "WaterMelon");
        hm.put(3, "Banana");
        hm.put(4, "Grapes");
        System.out.println(hm);

        // Getting value of a key:
        System.out.println(hm.get(2));
        System.out.println(hm.get(6));

        // Updadint/Changing value of a key
        hm.put(2, "Apple"); // will update the previous data in key 2

        // Remove a pair from the hashmap:
        System.out.println(hm.remove(2)); // returns the value as well
        System.out.println(hm);
        // Checking if a key is present
        System.out.println(hm.containsKey(3));
        System.out.println(hm.containsKey(2));
        System.out.println(hm.containsValue("Mango"));
        System.out.println(hm.containsValue("Apple"));

        // Adding a new entry only if the new key doesn't exist:
        hm.putIfAbsent(2, "Pineapple");

        // Getting all keys of the HashMap:
        System.out.println(hm.keySet());

        // Getting all values in the hashmap:
        System.out.println(hm.values());

        // Get all entries of the hashmap:
        System.out.println(hm.entrySet());

        System.out.println();


        // Traversing a HashMap:
        System.out.println("\nTraversing the HashMap:");

        // #1. iterating each pair using for each
        for (int i : hm.keySet()) {
            System.out.println(i + " " + hm.get(i));
        }

        System.out.println();

        // #2. iterate using for the entySet
        // dataType of data in hm.entrySet() -> Map.Entry
        for (Map.Entry<Integer, String> e : hm.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }

        System.out.println();

        // #2.1 from java 10, in for each, we dont need to mention type of data explicitly, just write "var"
        for (var v : hm.entrySet()) {
            System.out.println(v.getKey() + " " + v.getValue());
        }

        System.out.println();

        // #3. Iterate through the map using iterator:
        Iterator<Integer> itr = hm.keySet().iterator();
        while (itr.hasNext()) {
            int key = (int) itr.next();
            System.out.printf("Key: %d, Value: %s\n", key, hm.get(key));
        }

        System.out.println();

        /*
        TreeMap:
        tree data structure: node->keys 
        values will be mapped to the keys
        implemets navigable interface
        */
        // Tree Map
        System.out.println("\nTree Map:");
        TreeMap<Integer, String> tm = new TreeMap<>();
        tm.put(104, "Ravi");
        tm.put(102, "Lavesh");
        tm.put(105, "Anandu");
        tm.put(101, "Libin");
        tm.put(103, "Aruneet");

        System.out.println(tm);

        System.out.println("\nTraversing TreeSet: ");

        for (var m : tm.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        System.out.println();
        for (var m : tm.descendingKeySet()) {
            System.out.println(m + " " + tm.get(m));
        }

        System.out.println();
        // Navigable map interface:
        System.out.println(tm.descendingMap());
        System.out.println(tm.headMap(104));
        System.out.println(tm.headMap(104, true));
        System.out.println(tm.tailMap(102, false));
        System.out.println(tm.subMap(102, 104));

    }
}



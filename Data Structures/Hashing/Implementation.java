/*
insertion, removal, search/retrieval, contains -> O(1) time complexity

Hashing -> Converting an arbitrary sized key to a smaller sized key using some hash function.

Hash function:
- for same input, always gives same output
- a perfect hash function always produces unique output for a unique input, but that's not the case in non-perfect hash function(where collision could occur).

Generally used Hash functions:
1. Division method - H(k) = k mod M
2. Mid-square method - H(k) = H(k*k)
3. Digit folding method - divide into segments, take sum then mod M
4. Multiplication method - H(k) = floor(M(kA mod 1)) ; 0<A<1

Collision Resolution Technique:
1. Chaining (Open Hashing) -> Array of Linked List - O(n) Time complexity
2. Open Addressing (Closed Hashing) 
    - a. Linear Probing -> (H(k)+i) mod M
    - b. Quadritic Probing -> (H(k) + i^2) mod M
    - c. Double Hashing

In chaining, to achieve better time complexity, when the no. of entries in the map crosses the threshold value, a new bucket array of double the size of previous array is created and all the entries are copied from the old array to the new array.

eg. 
initial capacity, N = 4
load factor, L = 0.75
threshold value = L*N = 3 (as soon as a no of entries in map > 3, we'll increase capacity from 4 -> 8 and re-hash)


*/

/*
Now we will implement our own custom HashMap with following methods:
1. put(key, value)
    - returns void
    - inserts/updates

2. get(key)
    - returns value corresponding to key if it exists
    - returns null if key does not exists

3. size
    - returns teh no. of entries in HashMap

4. remove(key)
    - removes an entry with key 'key' from the HashMap
    - returns null or the value

Both key and value could be of any type, I
*/

import java.util.*;
 
public class Implementation {

    static class MyHashMap<K, V> {  // using generics. K, V could be any datatypes
        public static final int DEFAULT_CAPACITY = 4;
        public static final float DEFAULT_LOAD_FACTOR = 0.75f;

        private class Node {
            K key;
            V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // no. of entries in map
        private LinkedList<Node>[] buckets;

        private void initBuckets(int N) { // N -> capacity/size of buckets array
            buckets = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }
        }
        
        private int hashFunction(K key) {
            int hc = key.hashCode(); // using in-built function to get a hash key
            return (Math.abs(hc)) % buckets.length;
        }

        // Traverses the Linked List ll and looks for a node with key, if found, it returns its index, else returns null
        private int searchInBucket(LinkedList<Node> ll, K key) {
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key == key)
                    return i;
            }
            return -1;
        }

        private void reHash() {     // to ensure that load factor < 0.75 so as to have better time complexity
            LinkedList<Node>[] oldBuckets = buckets;
            initBuckets(oldBuckets.length * 2);
            n = 0;
            for (var bucket : oldBuckets) {
                for (var node : bucket) {
                    put(node.key, node.value);
                }
            }
        }

        public MyHashMap() {
            initBuckets(DEFAULT_CAPACITY);
        }

        public int size() { // returns the no. of entries in map
            return n;
        }
        
        public void put(K key, V value) { // to insert or update
            int bi = hashFunction(key); // bi -> bucket index
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket, key); // ei -> entry index
            
            if (ei == -1) { // key does not already exists, so insert a new node
                Node node = new Node(key, value);
                currBucket.add(node);
                n++;
            }
            else { // key already exists in map, so update its value
                Node currNode = currBucket.get(ei);
                currNode.value = value;
            }

            if (n >= buckets.length * DEFAULT_LOAD_FACTOR) {
                reHash();
            }
        }
        
        public V get(K key) {   
            int bi = hashFunction(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket, key);

            if (ei != -1) { // key exists
                Node currNode = currBucket.get(ei);
                return currNode.value;
            }
            // if key doesn't exists
            return null;
        }
        
        public V remove(K key) {
            int bi = hashFunction(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket, key);

            if (ei != -1) { // key exists
                Node currNode = currBucket.get(ei);
                V val = currNode.value;
                currBucket.remove(ei);
                n--;
                return val;
            }
            return null;
        }

    }
    public static void main(String[] args) {
        MyHashMap<String, Integer> students = new MyHashMap<>();
        System.out.println("Testing put");
        students.put("Libin", 37);
        students.put("Ravi", 31);
        students.put("Lavesh", 34);
        students.put("Aruneet", 42);
        students.put("Ravi", 36);  // update existing key

        System.out.println("\nTesting size: " + students.size());
        
        System.out.println("\nTesting get");
        System.out.println(students.get("Aruneet"));
        System.out.println(students.get("Libin"));
        System.out.println(students.get("Ravi"));
        System.out.println(students.get("Lavesh"));
        System.out.println(students.get("Jeevan")); // key doesn't exist in map
        
        System.out.println("\nTesting deletion");
        System.out.println(students.remove("Lavesh"));
        System.out.println(students.remove("Jeevan"));
        
        System.out.println("\nTesting size: " + students.size());
    }
}

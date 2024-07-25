import java.util.*;

public class SortWIthoutExtraSpace {

    public static void insertMinToRear(Queue<Integer> list, int min_index) {
        int min_value = 0;
        int s = list.size();
        for (int i = 0; i < s; i++) {
            int current = list.poll();
            
            if (i != min_index)
                list.add(current);
            else
                min_value = current;
        }
        list.add(min_value);
    }

    public static int minIndex(Queue<Integer> list, int sortIndex) {
        int min_index = -1;
        int min_value = Integer.MAX_VALUE;
        int s = list.size();
        for (int i = 0; i < s; i++) {
            int current = list.poll();;
            
            if (current <= min_value && i <= sortIndex) {
                min_index = i;
                min_value = current;
            }
            list.add(current);
        }
        return min_index;
    }
    
    public static void sortQueue(Queue<Integer> list) {
        for (int i = 1; i <= list.size(); i++) {
            int min_index = minIndex(list, list.size() - i);
            insertMinToRear(list, min_index);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> list = new LinkedList<Integer>();
        System.out.println("Enter no. of elements in list: ");
        int n = sc.nextInt();
        System.out.println("Enter the list elements: ");
        for (int i = 0; i < n; i++) {
            int element = sc.nextInt();
            list.add(element);
        }

        System.out.println(list);
        
        sortQueue(list);
        
        System.out.println(list);

        for (var i : list) {
            System.out.print(i + " ");
        }
        
        
    }
}

import java.util.Stack;

// Iteratively
/*
public class TowerOfHanoi {
    static void towerOfHanoi(int numDisks, char source, char auxiliary, char destination) {
        // Create three stacks to represent the three rods
        Stack<Integer> sourceStack = new Stack<>();
        Stack<Integer> auxiliaryStack = new Stack<>();
        Stack<Integer> destinationStack = new Stack<>();

        // Initialize the source rod with disks
        for (int i = numDisks; i >= 1; i--) {
            sourceStack.push(i);
        }

        // Total number of moves required
        int totalMoves = (int) Math.pow(2, numDisks) - 1;

        // Determine the order of pegs for odd/even number of disks
        char temp;
        if (numDisks % 2 == 0) { // if no of disks is even -> interchange auxiliary and destination
            temp = auxiliary;
            auxiliary = destination;
            destination = temp;
        }
        
        // Perform iterative Tower of Hanoi
        for (int move = 1; move <= totalMoves; move++) {
            if (move % 3 == 1) {
                moveDisk(sourceStack, destinationStack, source, destination);
            } else if (move % 3 == 2) {
                moveDisk(sourceStack, auxiliaryStack, source, auxiliary);
            } else if (move % 3 == 0) {
                moveDisk(auxiliaryStack, destinationStack, auxiliary, destination);
            }
        }
    }

    static void moveDisk(Stack<Integer> sourceStack, Stack<Integer> destinationStack, char source, char destination) {
        if (!sourceStack.isEmpty() && (destinationStack.isEmpty() || sourceStack.peek() < destinationStack.peek())) {
            destinationStack.push(sourceStack.pop());
            System.out.println("Move disk " + destinationStack.peek() + " from " + source + " to " + destination);
        } else {
            sourceStack.push(destinationStack.pop());
            System.out.println("Move disk " + sourceStack.peek() + " from " + destination + " to " + source);
        }
    }

    public static void main(String[] args) {
        int numDisks = 3; // Change the number of disks as needed
        char source = 'A';
        char auxiliary = 'B';
        char destination = 'C';
        towerOfHanoi(numDisks, source, auxiliary, destination);
    }
}
*/

// Recursively:
public class TowerOfHanoi {
    public static void main(String[] args) {
        int numDisks = 3; // Number of disks
        char source = 'A';
        char auxiliary = 'B';
        char destination = 'C';
        towerOfHanoi(numDisks, source, auxiliary, destination);
    }

    public static void towerOfHanoi(int numDisks, char source, char auxiliary, char destination) {
        if (numDisks == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        towerOfHanoi(numDisks - 1, source, destination, auxiliary);
        System.out.println("Move disk " + numDisks + " from " + source + " to " + destination);
        towerOfHanoi(numDisks - 1, auxiliary, source, destination);
    }
}

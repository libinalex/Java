/* 
Suppose we've to develop following

    |-------------------------|
    |     Inventory           |
    |-------------------------|
    | • nuts   - 3 x 10 = 30  |
    | • bolts  - 2 x 20 = 40  |
    | • screws - 1 x 30 = 30  |
    |-------------------------|
    | - totalCost() => 100    |
    |-------------------------|

And we implement it in following way:
*/

/*
import java.util.*;

class Nut {
    private int nutCost;

    Nut() {
        nutCost = 10;
    }

    int nutCost() {
        return nutCost;
    }
}

class Bolt {
    private int boltCost;

    Bolt() {
        boltCost = 20;
    }

    int boltCost() {
        return boltCost;
    }
}

class Screw {
    private int screwCost;

    Screw() {
        screwCost = 30;
    }

    int screwCost() {
        return screwCost;
    }
}

class Inventory {
    ArrayList<Nut> nuts = new ArrayList<>();
    ArrayList<Bolt> bolts = new ArrayList<>();
    ArrayList<Screw> screws = new ArrayList<>();

    void addNut(Nut n) {
        nuts.add(n);
    }
    void addBolt(Bolt b) {
        bolts.add(b);
    }

    void addScrew(Screw s) {
        screws.add(s);
    }
    
    int totalCost() {
        int total = 0;
        for(Nut n: nuts) // n1, n2, n3
            total = total + n.nutCost();
        for(Bolt b: bolts) // b1, b2
            total = total + b.boltCost();
        for(Screw s: screws) // s1
            total = total + s.screwCost();

        return total;
    }
}

public class PolymorphicApproach {
    public static void main(String[] args) {
        Inventory i = new Inventory();

        Nut n1 = new Nut();
        Nut n2 = new Nut();
        Nut n3 = new Nut();
        i.addNut(n1);
        i.addNut(n2);
        i.addNut(n3);

        Bolt b1 = new Bolt();
        Bolt b2 = new Bolt();
        i.addBolt(b1);
        i.addBolt(b2);

        Screw s1 = new Screw();
        i.addScrew(s1);

        System.out.println("Total Cost: " + i.totalCost()); // 100
    }
}
*/


/* 
In above program we haven't used any polymorphism. 
Even though the above program gives desired output, but it has some drawbacks.
For eg. in Future, if we wish to add another item, say 
Nail - 4 x 25 = 100 
We will have to modify the codes, in Inventory we have to add another ArrayList, in calculating totalCost() we have to add additional lines of codes...and so on.

Therefore, in order to avoid this, we can use Polymorphic approach
*/

import java.util.*;

abstract class Item {
    abstract int cost();
}

class Nut extends Item {
    private int nutCost;

    Nut() {
        nutCost = 10;
    }

    int cost() {
        return nutCost;
    }
}

class Bolt extends Item{
    private int boltCost;

    Bolt() {
        boltCost = 20;
    }

    int cost() {
        return boltCost;
    }
}

class Screw extends Item {
    private int screwCost;

    Screw() {
        screwCost = 30;
    }

    int cost() {
        return screwCost;
    }
}

class Inventory {
    ArrayList<Item> items = new ArrayList<>();

    void addItem(Item i) {
        items.add(i);
    }

    int totalCost() {
        int total = 0;
        for (Item i : items) // n1, n2, n3, b1, b2, s1
            total = total + i.cost(); // which cost() method will be called(Bolt, Nut, Screw) is decided at runtime -> Runtime Polymorphism
        
        return total;
    }
}

public class PolymorphicApproach {
    public static void main(String[] args) {
        Inventory i = new Inventory();

        // Base is referring to Sub-class now
        Item n1 = new Nut();
        Item n2 = new Nut();
        Item n3 = new Nut();
        i.addItem(n1);
        i.addItem(n2);
        i.addItem(n3);

        Item b1 = new Bolt();
        Item b2 = new Bolt();
        i.addItem(b1);
        i.addItem(b2);

        Item s1 = new Screw();
        i.addItem(s1);

        System.out.println("Total Cost: " + i.totalCost()); // 100
    }
}

/* 
Now to add another item, say Nail, we just need to create another class Nail tht extends Item class and give its cost.
No change needs to be done on Inventory class.
*/
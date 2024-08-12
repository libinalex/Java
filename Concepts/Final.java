/*
--- final ---
is a keyword, non-access modifier
When used with:
variable -> variable becomes constant(cannot be updated)
method -> method cannot be overriden from a subclass
class -> class cannot be inherited
*/

public class Final {
    final int age=100;
    final void display() {
        age = 50;                   // error - cannot assign a value to final variable age
    }

    public static void main(String[] args) {
        Final f = new Final();
        System.gc(); // requesting the jvm to call garbage collector(usually calls automatically in backend)
        System.out.println("Main completed");
        System.out.println(f.age);
    }

    // public void finalize() {    // cannot override as method is depricated after jdk19
    //     System.out.println("finalize method overriden");
    // }
}

final class Example extends Final {
    void display() {                // error - cannot override display() as overridden method is final
        System.out.println("Overriding a final method from parent class");
    }
}

class Ex2 extends Example {         // error - cannot inherit from final Example class
    void output() {
        System.out.println("Inheriting a final class");
    }
}


/*
--- finalize ---
is a method used by garbage collector in java just before we delete or destroy an object.
closes the resources corresponding to that object
deallocates the object
not a reserved keyword
finalize method is in the class object
will go hand-in-hand with try-catch block
is a depricated method in jdk 18
*/

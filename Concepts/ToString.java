/* 
When an object is displayed using sout(), internally toString() method is invoked implicitly
toString() belongs to Object class
toString() of Object class returns the 'class name @ hashcode' of the object
*/
class Product {
    int pid;
    String pname;

    Product(int pid, String pname) {
        this.pid = pid;
        this.pname = pname;
    }

    Product() {
    }

    // public String toString() {
    //     return "Product id: " + pid + "\nProduct Name: " + pname;
    // }
}

public class ToString {
    public static void main(String[] args) {
        Product prod = new Product(101, "Keyboard");
        System.out.println(prod); // Product@3fee733d -> toString() method implicitly

    }
}

/* 
Product class does not have any toString() method explicitly. 
We know that every class in java extends Object class, so the toString() method invoked will be from Object class, which displays Classname along with Hashcode

Thus, in order to represent the object value in String or readable formet, we need to override toString() method in the class.
*/

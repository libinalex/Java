/* 
Non static blocks : code written within { }, 
    is executed for each object that is created.
    is executed before the constructor's execution
*/

class A {
    int a;
    {
        System.out.println("\nNon-static block of an instatnce of class A");
        System.out.println("Value of a is: " + a);
        a = 10;
    }

    A() {
        System.out.println("Constructor of Class A");
        System.out.println("Value of a is: " + a);
    }

    A(int a) {
        this.a = a;
        System.out.println("Constructor of Class A");
        System.out.println("Value of a is: " + a);
    }
    
}
public class NonStaticBlock {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A(20);
    }
}


/* 
Static Blocks:

A static block is mostly used for initializing values of static variables.
A static block is declared using static keyword.
Static blicks are executed when the class is loaded in memory.
Static blicks are invoked before constructors.
Instsnce varisbles cannot be accessed inside static blocks.

There can be multiple static blocks inside a class.
In that case they are called only once in the order that they appear in the source code.


*/

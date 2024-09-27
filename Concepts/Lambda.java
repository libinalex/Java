/* 
Lambda Expression
- The expression through which we can represent anonymous method
- Anonymous method is a method which does not have any name
- Syntax:
 Parameter   Expression          Body
    ()          ->          sout("Lambda")
*/

/*
Functional Interface
- The interface which contains only one abstract method but can hava multiple default and static methods is called as functional interface. {SAM - Single Abstract Method}
- @FunctionalInterface annotation is used to mark the interface as functional interface
- Built-in / Default Functional Interfaces examples in Java:
    - Runnable interface -> run()
    - Callable interface -> call()
    - Comparator interface -> compare()
    - Comparable interface -> compareTo()
    - ActionListener interface -> actionPerformed()

- Lambda expressions can be invoked only through functional interfaces. So, for the above methods, we can use Lambda Expressions
*/

/*
@FunctionalInterface
interface Phone {
    // void call();
    void call(int num);
    // void func(); -> error: @FunctionalInterface can have only 1 abstract method
}

// class AndroidPhone implements Phone {
//      @Override
//      public void call() {
//          System.out.println("Calling in subclass");
//      }
// }

// Here we're creating the subclass only to override the call() method.
// Instead of doing this, we can make use of Anonymous Inner Class

public class Lambda {
    public static void main(String[] args) {
        // Phone p = new AndroidPhone();

        // Anonymous Inner Class
        // Phone p = new Phone(){
        //     public void call(){
        //         System.out.println("Calling in Anonymous class");
        //     }
        // };


        // Using Lambda Expression - 

        // Phone p = () -> {
        //     System.out.println("Calling");
        // };
        // p.call(); 

        // If we have only one statement, then using curly braces{} is optional
        // Phone p = () -> System.out.println("Calling");
        // p.call();
        
        // If the method is taking an argument, pass the argument in parenthesis 
        // Phone p = (int num) -> System.out.println("Calling: " + num);
        // p.call(98295);
        
        // Since we already know the datatype of the argument from interface declaration, mentioning data type is also optional
        // Phone p = (num) ->  System.out.println("Calling: " + num);
        // p.call(98295);
        
        // If there is only one argument in the method, then providing parenthesis is also optional
        Phone p = no -> System.out.println("Calling: " + no);
        p.call(912576); 

    }
}
*/

/* 
- Lambda was introduced in java to bring the Functional Programming features in java(Object Oriented Programming) and to improve code optimization(concise code)

OOP -> Classes and Objects
Functional Programming -> Functions and Variables

Anonymous Function - Function which does not have: name, return type and access modifier.

public void getSquare(int a){
    return (a*a);
}

can be written as:

- (int a) -> {return (a*a);};
- (a) -> a*a;
- a -> a*a;

Note: If we are mentioning 'return', we need to use curly braces{}. We can remove the 'return' and {} if only one statement is there in method. If we're not using 'return' to return, then we need to remove {} as well.

Vaild lambda statements:
n -> {return n*n;};
n -> n*n;

In-valid statements:
n -> return n*n;
n -> {return n*n};
n -> {n*n};

*/

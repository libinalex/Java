public class Variables {
    // static variables - can be shared amog all instances of a class
    static int a = 10;

    // instance variable - declared inside a class but outside the body of a method. Its value is instance-specific and is not shared among instances. has default values.

    int b; // default int = 0; String = null, boolean = false
    String c = "Hello I am an instance variable.";

    public static void main(String[] args) {
        // local variable - declared inside the body of a method. Can be used only within the method. Cannot be defined with static.
        int d = 30;

        // static and local variables can be called directly.
        System.out.println(a);
        System.out.println(d);

        // to access an instance variable, object has to be created
        Variables var1 = new Variables();
        System.out.println(var1.b);
        System.out.println(var1.c);
        
        // every object will have new copy of instance variable.
        Variables var2 = new Variables();
        System.out.println(var2.b+3);
        System.out.println(var2.c);

    }
}
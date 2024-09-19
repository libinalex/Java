/* 
Primitive data types

Data type    Size      Default value
byte        1 byte      0
short       2 bytes     0
char        2 bytes     ' '
int         4 bytes     0
long        8 bytes     0
float       4 bytes     0.0
double      8 bytes     0.0
boolean     1 bit       false

int -> 4 bytes = 4 x 8 bits = 32 bits = -2^31 to 2^31

Reference data types:
Arrays, Predefined Classes: Sytem, String, Math, Thread, LinkedList, ...
Userdefined Classes: Person, Customer, Student, Employee, Account, ...

Important Points:
- Default values are applicable only to the data members(declared within the class) of the class
  not for local variables (declared within a method)
- Local variables need to be initialized
- Memory allocation for primitive data type is done by declaring the variable: int a; -> 4 byted memory allocated
- Memory allocation for reference data type is done during runtime using new operator
- Default value of reference data type is null

Type casting:
Implicit: converting lower to higher data type
Explicit: converting higher to lower data type
*/

public class Basics {
    int var1; // data member
    String s; // data member

    void printNum() {
        int var2; // local variable :- have to be initialised
        System.out.println(var1); // primitive type: 0 
        System.out.println(s); // reference type: null
        // System.out.println(var2); // error: variable var2 might not have been initialized
    }
    public static void main(String[] args) {
        Basics b = new Basics();
        System.out.println(b.var1); // primitive type: 0
        b.printNum();
        String str; // local variable
        // System.out.println(str); // error: variable str might not have been initialized

        // Type casting
        int n = 125;
        long x = n; // Implicit
        
        char c = 'A';
        int ch = c; // Implicit
        System.out.println(x + " " + ch);

        long y = 185;
        int w = (int) y; // Explicit

        double d = 16.5;
        byte b1 = (byte) d;
        System.out.println(w + " " + b1); // Explicit
    
        // float f = 35.5; // error - In java a value with decimal point is double data type, higher(double) to lower(float) not implicit
        float f1 = (float) 35.5; // Explicit
        float f2 = 38.7f; // Explicit
        System.out.println(f1 + " " + f2);
        

    }
}

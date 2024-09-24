/*
There are many types of operators in Java which are given below:

Unary Operator,
Arithmetic Operator,
Shift Operator,
Relational Operator,
Bitwise Operator,
Logical Operator,
Ternary Operator and
Assignment Operator.


Java Operator Precedence:

Operator Type	     Category        	    Precedence

Unary	            postfix	                expr++ expr--
                    prefix	                ++expr --expr +expr -expr ~ !

Arithmetic	        multiplicative	        * / %
                    additive	            + -

Shift	            shift	                << >> >>>

Relational	        comparison	            < > <= >= instanceof
                    equality	            == !=

Bitwise	            bitwise AND         	&
                    bitwise exclusive OR	^
                    bitwise inclusive OR	|

Logical	            logical AND	            &&
                    logical OR	            ||

Ternary	             ternary	            ? :

Assignment	         assignment	            = += -= *= /= %= &= ^= |= <<= >>= >>>=

*/


public class Operators {

    public static void main(String[] args) {
        int a = 12;
        int b = 7;
        int c = 16;

        // Using ternary operator to find maximum of three numbers:
        int largest = (a > b && a > c) ? a : (b > c) ? b : c;
        
        System.out.println("Largest among the three numbers is: " + largest);
    }
}
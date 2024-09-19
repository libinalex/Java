/*
1. Define a class called Admission to check whether a student is eligible for taking admission in class XI with the following specifications:

Input Data members Name, Maths, Science, Computer, Result (Pass or Fail)

 

Member Methods	Purpose
Admission( )	parameterised constructor to initialize the data members by accepting the details of a student
check( )	to check the eligibility for course based on the table given below
void display()	to print the eligibility by using check() function in nested form
Marks	Eligibility
Pass + 90% or more in all the subjects	Bio-Science with Maths
Pass + Average marks 90% or more	Bio-Science with Computer
Pass + Average marks 80% or more and less than 90%	Bio-Science with Psychology
Write the main method to create an object of the class and call all the member methods.

Input
Louis
94
98
93
Pass

Expected output
Eligibility: Bio-Science with Maths
*/
/* 
public class Questions {

}
*/
/*
2. Create an array of objects of the Student class, of size 'n'. The Student
class is defined below. Create three objects of the Student class, with
values, and assign the objects to the array. Loop through the array and print
the name, grade, and email of all students as below:


Input
3
Peter
3
p@gmail.com
John
4
j@gmail.com
Lisa
5
l@gmail.com

Expected output
Peter 3 p@gmail.com
John 4 j@gmail.com
Lisa 5 l@gmail.com
*/

import java.util.*;

class Student {
    String name;
    int grade;
    String email;

    void input() {
        Scanner sc = new Scanner(System.in);
        name = sc.next();
        grade = sc.nextInt();
        email = sc.next();
    }

    void display() {
        System.out.println(name + " " + grade + " " + email);
    }
}

public class Questions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Students: ");
        int n = sc.nextInt();

        Student S[] = new Student[n];

        for (int i = 0; i < n; i++) {
            S[i] = new Student();
            S[i].input();
        }

        for (int i = 0; i < n; i++) {
            S[i].display();
        }

    }
}

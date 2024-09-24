/*
A company has hired three types of salespersons, A, B and C. Write a Java program using inheritance, constructor, and overloading/overriding to perform the following: 
Create appropriate superclass and sub-classes. Initialize data members for the product with Product Id  =P01, Price=10000, and Quantity (get input) using a constructor.
The salesmen will give a single discount (10%), and a double discount (an additional 5% after discounting 10% if quantity >=50) depending on the quantity demanded. Use overload methods Disc(int), and Disc(int,int) to calculate the single discount and double discount. Calculate and display the amount to be paid by the customer after getting discounts on the price of the product.
Compute the total amount of sales of each salesperson type. A cash prize of Rs.1000 will be awarded to the salesperson who sold the highest amount.
Compute the total commission for each salesperson if the commission rate is 2% for type ‘A’ 1.5% for type ‘B’ and 1% for type ‘C’.
Find the total income for each salesperson for a day if each salesperson receives a fixed salary of Rs. 700 per day in addition to commission payments and the award amount.

A
50
B
100
C
20
*/

import java.util.*;

class Salesperson {
    String ProductId;
    double Price;
    int Quantity;
    double Sales;
    int Salary;

    Salesperson(int q) {
        ProductId = "P01";
        Price = 10000;
        Quantity = q;
        Salary = 0;
    }

    void Disc(int x) {
        Price = 0.9 * Price;
    }

    void Disc(int x, int q) {
        if (q >= 50) {
            Price = 0.9 * Price;
            Price = 0.95 * Price;
        }
    }

    void CalcSales() {
        Sales = Quantity * Price;
        System.out.println("Rs. " + (int) Sales);
    }

    void CalcSalary() {
        Salary += 700;
    }

    void Award() {
        Salary += 1000;
    }

    void PrintSal() {
        System.out.println("Rs. " + Salary);
    }
}

class A extends Salesperson {
    public A(int quantity) {
        super(quantity);
    }

    void Commission() {
        Salary += 2 * Sales / 100;
        System.out.println("Rs. " + Salary);
    }

}

class B extends Salesperson {
    public B(int quantity) {
        super(quantity);
    }

    void Commission() {
        Salary += 1.5 * Sales / 100;
        System.out.println("Rs. " + Salary);
    }
}

class C extends Salesperson {
    public C(int quantity) {
        super(quantity);
    }

    void Commission() {
        Salary += 1 * Sales / 100;
        System.out.println("Rs. " + Salary);
    }
}

public class PAT {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        String A = x.next();
        int Aq = x.nextInt();
        String B = x.next();
        int Bq = x.nextInt();
        String C = x.next();
        int Cq = x.nextInt();
        A a1 = new A(Aq);
        B b1 = new B(Bq);
        C c1 = new C(Cq);
        if (a1.Quantity >= 50)
            a1.Disc(1, Aq);
        else
            a1.Disc(1);
        if (b1.Quantity >= 50)
            b1.Disc(1, Bq);
        else
            b1.Disc(1);
        if (c1.Quantity >= 50)
            c1.Disc(1, Cq);
        else
            c1.Disc(1);
        System.out.println("Sales: ");
        System.out.print("A: ");
        a1.CalcSales();
        System.out.print("B: ");
        b1.CalcSales();
        System.out.print("C: ");
        c1.CalcSales();
        System.out.println("Commission:");
        System.out.print("A: ");
        a1.Commission();
        System.out.print("B: ");
        b1.Commission();
        System.out.print("C: ");
        c1.Commission();
        System.out.println("Salary:");
        a1.CalcSalary();
        b1.CalcSalary();
        c1.CalcSalary();
        if (a1.Salary >= b1.Salary && a1.Salary >= c1.Salary)
            a1.Award();
        else if (b1.Salary >= c1.Salary)
            b1.Award();
        else
            c1.Award();
        System.out.print("A: ");
        a1.PrintSal();
        System.out.print("B: ");
        b1.PrintSal();
        System.out.print("C: ");
        c1.PrintSal();
    }
}

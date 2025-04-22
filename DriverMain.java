DriverMain.java

import java.util.Scanner;

// Interface Taxable
interface Taxable {
    double salesTax = 0.07;
    double incomeTax = 0.105;

    void calcTax(); // abstract method
}

// Employee class
class Employee implements Taxable {
    int empId;
    String name;
    double salary;

    Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    public void calcTax() {
        double yearlySalary = salary * 12;
        double tax = yearlySalary * incomeTax;
        System.out.println("Income Tax for " + name + ": ₹" + tax);
    }
}

// Product class
class Product implements Taxable {
    int pid;
    double price;
    int quantity;

    Product(int pid, double price, int quantity) {
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
    }

    public void calcTax() {
        double tax = price * salesTax;
        System.out.println("Sales Tax on product ID " + pid + ": ₹" + tax);
    }
}

// DriverMain class
public class DriverMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Employee Input
        System.out.println("Enter Employee Details:");
        System.out.print("ID: ");
        int empId = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Monthly Salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(empId, name, salary);
        emp.calcTax();

        // Product Input
        System.out.println("\nEnter Product Details:");
        System.out.print("Product ID: ");
        int pid = sc.nextInt();
        System.out.print("Price: ");
        double price = sc.nextDouble();
        System.out.print("Quantity: ");
        int quantity = sc.nextInt();

        Product prod = new Product(pid, price, quantity);
        prod.calcTax();

        sc.close();
    }
}

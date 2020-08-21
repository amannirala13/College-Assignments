package com.asdev.classes;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeExample {

    static class Employee{

        long code;
        String name, designation;

        Employee(long code, String name, String designation){
            this.code = code;
            this.name = name;
            this.designation = designation;
        }

        void printData(){
            System.out.println("--------------[Employee Data]--------------");
            System.out.println("Name: "+ this.name);
            System.out.println("Code: "+this.code);
            System.out.println("Designation: "+ this.designation);
        }
    }

    static Employee inputData(Scanner sc){
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter Code: ");
        long code = Long.parseLong(sc.nextLine());
        System.out.print("Enter Designation: ");
        String designation = sc.nextLine();
        return new Employee(code, name, designation);
    }

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        char input = 'y';
        Scanner sc = new Scanner(System.in);
        while(true){
            if(input == 'y' || input == 'Y')
                employees.add(inputData(sc));
            else
                break;
            System.out.print("Do you want to continue adding Employee? (y/n) : ");
            input = sc.nextLine().charAt(0);
        }
        empPrint(employees);
    }

    private static void empPrint(ArrayList<Employee> employees) {
        for (Employee employee: employees){
            employee.printData();
        }
    }
}


/*
---------------------[OUTPUT]---------------------

Enter name: Aman Nirala
Enter Code: 10
Enter Designation: Student at SIU
Do you want to continue adding Employee? (y/n) : y
Enter name: Adam Eve
Enter Code: 00
Enter Designation: First Humans
Do you want to continue adding Employee? (y/n) : n
--------------[Employee Data]--------------
Name: Aman Nirala
Code: 10
Designation: Student at SIU
--------------[Employee Data]--------------
Name: Adam Eve
Code: 0
Designation: First Humans


------------------------------------------
Process finished with exit code 0
*/

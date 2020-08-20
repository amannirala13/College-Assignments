package com.asdev.array;
// Author: amannirala13
import java.util.ArrayList;
import java.util.Scanner;

public class Student_Array {
    public static class Student{
        long PRN;
        String name,course;
        ArrayList<Double> subjectMarks;
        double totalMarks;
        double grade;
        String result;

        Student(long PRN, String name, String course, ArrayList<Double>subjectMarks){
            this.PRN = PRN;
            this.name = name;
            this.course = course;
            this.subjectMarks = subjectMarks;
            this.totalMarks = addMarks();
            this.grade = getGrades();
            this.result = getResult();
        }

        private double getGrades() {
            return this.totalMarks /(100*this.subjectMarks.size())*100;
        }

        private String getResult() {

            if(this.totalMarks <= getPercentMarks(90))
                if(this.totalMarks <= getPercentMarks(70))
                    if(this.totalMarks <= getPercentMarks(60))
                        if(this.totalMarks <= getPercentMarks(50))
                            if(this.totalMarks <= getPercentMarks(40))
                                return "F";
                            else
                                return "E";
                        else
                            return "D";
                    else
                        return "C";
                else
                    return "B";
            else
                return "A";

        }

        double getPercentMarks(double percent){
            int totalMarks = 100*this.subjectMarks.size();
            return percent*totalMarks/100;
        }

        private Double addMarks(){
            double total = 0.0;
            for(double mark: this.subjectMarks){
                total += mark;
            }
            return total;
        }

        public void printResult(){
            System.out.println("-----------------[ RESULT ]-----------------");
            System.out.println("Name: "+ this.name);
            System.out.println("PRN: "+ this.PRN);
            System.out.println("Course: "+ this.course);
            System.out.println("Subject Marks: "+ this.subjectMarks);
            System.out.println("Total Marks: "+ this.totalMarks +" out of "+ (100*this.subjectMarks.size()));
            System.out.println("Percentage: "+ this.grade);
            System.out.println("Result Grade: "+ this.result);

        }

    }

    public static void main(String[] args) {

        ArrayList<Double> marks = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.print("Student Name: ");
        String name = sc.nextLine();
        System.out.print("Student PRN: ");
        long PRN = sc.nextLong();
        System.out.print("Student Course: ");
        String course = sc.next();
        System.out.println("Marks input (Enter \"exit\" to stop):--------------------- ");
        String input;
        while (true){
            System.out.print("Enter subject mark: ");
            input = sc.next();
            if(input.equalsIgnoreCase("exit")){
                break;
            }
            else
                marks.add(Double.parseDouble(input));
        }

        Student s1 = new Student(PRN, name, course, marks);
        s1.printResult();
    }
}

/*

------------ OUTPUT ------------------

Student Name: Aman Nirala
Student PRN: 19030121010
Student Course: CS
Marks input (Enter "exit" to stop):---------------------
Enter subject mark: 100
Enter subject mark: 90
Enter subject mark: 50
Enter subject mark: 100
Enter subject mark: 50
Enter subject mark: exit
-----------------[ RESULT ]-----------------
Name: Aman Nirala
PRN: 19030121010
Course: CS
Subject Marks: [100.0, 90.0, 50.0, 100.0, 50.0]
Total Marks: 390.0 out of 500
Percentage: 78.0
Result Grade: B

--------------------------------------
Process finished with exit code 0

*/

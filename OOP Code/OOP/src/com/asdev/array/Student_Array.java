package com.asdev.array;
// Author: amannirala13
import java.util.ArrayList;

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
        marks.add(50.0);
        marks.add(50.0);
        Student s1 = new Student(10, "Aman Nirala", "BCA", marks);
        s1.printResult();
    }
}

/*

------------ OUTPUT ------------------

Name: Aman Nirala
PRN: 10
Course: BCA
Subject Marks: [50.0, 50.0]
Total Marks: 100.0 out of 200
Percentage: 50.0
Result Grade: E

--------------------------------------
Process finished with exit code 0

*/

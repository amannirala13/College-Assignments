package com.asdev.IOFiles;

import java.io.*;

public class objectSerialization {

    static class Student implements Serializable {
        long prn;
        String name, program, course;
        int semester;
        double attendancePercent;

        Student(long prn, String name, String program, String course, int semester, double attendancePercent){
            this.prn = prn;
            this.name = name;
            this.program = program;
            this.course = course;
            this.semester = semester;
            this.attendancePercent = attendancePercent;
        }

        void printAll(){
            System.out.println("PRN: "+this.prn);
            System.out.println("Name: "+this.name);
            System.out.println("Program: "+this.program);
            System.out.println("Course: "+this.course);
            System.out.println("Semester: "+this.semester);
            System.out.println("Attendance Percentage"+this.attendancePercent);
        }
    }

    public static void main(String[] args) {
        Student std = new Student(1,"Aman", "BCA", "BCA", 2, 75d);
        Student std2 = new Student(2,"Aman", "BCA", "BCA", 3, 75d);
        Student std3 = new Student(3,"Aman", "BCA", "BCA", 4, 75d);
        Student std4 = new Student(4,"Aman", "BCA", "BCA", 5, 75d);

        try{
            FileOutputStream FOs = new FileOutputStream("stud.txt");
            ObjectOutputStream ObjOs = new ObjectOutputStream(FOs);
            ObjOs.writeObject(std);
            ObjOs.writeObject(std2);
            ObjOs.writeObject(std3);
            ObjOs.writeObject(std4);
            FOs.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        try{
            FileInputStream FIs = new FileInputStream("stud.txt");
            ObjectInputStream ObjIs = new ObjectInputStream(FIs);
            Student stdRead = (Student) ObjIs.readObject();
            Student std2Read = (Student) ObjIs.readObject();
            Student std3Read = (Student) ObjIs.readObject();
            Student std4Read = (Student) ObjIs.readObject();

            stdRead.printAll();
            std2Read.printAll();
            std3Read.printAll();
            std4Read.printAll();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

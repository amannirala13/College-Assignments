package com.asdev.classes;

public class Assignment1 {

    public static class Rectangle{
        public double length, width;
    }

    public static class Box extends Rectangle{
        public double height;

        Box( double l, double w, double h){
            this.length = l;
            this.width = w;
            this.height = h;
        }
        public double area(){
            return (this.length*this.height*this.width);
        }
    }
    public static void main(String[] args) {
        Box obj = new Box(10,20,10);
        System.out.println(obj.area());
    }
}

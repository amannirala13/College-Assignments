package com.asdev.classes;

public class Assignment1_1 {

    static class Bicycle implements vehicle{
        int gear, speed;

        Bicycle(int g, int s){
            this.gear = g;
            this.speed = s;
        }

        @Override
        public void changeGear(int a) {
            this.gear = a;
        }

        @Override
        public void speedUp(int a) {
            this.speed += a;
        }

        @Override
        public void applyBreak(int a) {
            this.speed -= a;
        }

        public void display(){
            System.out.println("Gear = "+this.gear);
            System.out.println("Speed = "+this.speed);
        }
    }

    static class Car implements vehicle{
        int gear, speed;

        Car(int g, int s){
            this.gear = g;
            this.speed = s;
        }

        @Override
        public void changeGear(int a) {
            this.gear = a;
        }

        @Override
        public void speedUp(int a) {
            this.speed += a;
        }

        @Override
        public void applyBreak(int a) {
            this.speed -= a;
        }

        public void display(){
            System.out.println("Gear = "+this.gear);
            System.out.println("Speed = "+this.speed);
        }
    }

    static class Bike implements vehicle{
        int gear, speed;

        Bike(int g, int s){
            this.gear = g;
            this.speed = s;
        }

        @Override
        public void changeGear(int a) {
            this.gear = a;
        }

        @Override
        public void speedUp(int a) {
            this.speed += a;
        }

        @Override
        public void applyBreak(int a) {
            this.speed -= a;
        }

        public void display(){
            System.out.println("Gear = "+this.gear);
            System.out.println("Speed = "+this.speed);
        }
    }

    interface vehicle{
        void changeGear(int a);
        void speedUp(int a);
        void applyBreak(int a);
    }
    public static void main(String[] args) {
        Bike bk = new Bike(4, 100);
        Bicycle bi = new Bicycle(4, 40);
        Car cr = new Car(4, 120);

        bk.display();
        bi.display();
        cr.display();

        bk.changeGear(1);
        bk.display();

        bk.applyBreak(50);
        bk.display();

        bk.speedUp(50);
        bk.display();

        bi.changeGear(1);
        bi.display();

        bi.applyBreak(10);
        bi.display();

        bi.speedUp(10);
        bi.display();

        cr.changeGear(1);
        cr.display();

        cr.applyBreak(50);
        cr.display();

        cr.speedUp(50);
        cr.display();

    }
}

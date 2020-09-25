package com.asdev.exceptions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class NumberFormatExceptionExample {
    ArrayList<Integer> numberList = new ArrayList<>();

    public void inputValues(){
        String input;
        int num;
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Enter value: ");
            input = sc.next();
            if(input.equalsIgnoreCase("exit"))
                break;
            else{
                try{
                    num = Integer.parseInt(input);
                    numberList.add(num);
                }catch (NumberFormatException e) {
                    System.out.println("ERROR: " + e.getMessage());
                    System.out.println("SOLUTION: Only enter integers!");
                }

                finally {
                    numberList.sort(Comparator.naturalOrder());
                }
            }
        }
    }

    public int getSum(){
        int sum = 0;
        for (Integer integer : numberList)
            sum += integer;
        return sum;
    }

    public Double getAvg(){
        return getSum()/(double)numberList.size();
    }

    public int getMax(){
        return numberList.get(numberList.size()-1);
    }

    public int getMin(){
        return numberList.get(0);
    }

    public static void main(String[] args) {
        NumberFormatExceptionExample obj = new NumberFormatExceptionExample();
        obj.inputValues();
        System.out.println("SUM = "+obj.getSum());
        System.out.println("AVERAGE = "+obj.getAvg());
        System.out.println("MAX = "+obj.getMax());
        System.out.println("MIN = "+obj.getMin());
    }

}

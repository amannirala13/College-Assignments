package com.asdev.array;

import java.util.*;

public class myArrayAssignment {

    public static class myArray extends ArrayList<Integer> {

        public void sort(){
            this.sort(Comparator.naturalOrder());
        }

        public Integer getMax() {
            this.sort();
            return this.get(this.size()-1);
        }

        public Integer getMin() {
            this.sort();
            return this.get(0);
        }
        public Double getAverage(){
            int sum = 0;
            for (Integer integer : this) {
                sum += integer;
            }
            return sum/ (double) this.size();
        }

        public void sortDescending() {
            this.sort(Comparator.reverseOrder());
        }
    }

    public static boolean INPUT_FLAG = true;

    public static void main(String[] args) {
        myArray myList = new myArray();
        Scanner sc = new Scanner(System.in);
        String input;
        System.out.println("To exit input, type \"exit\"!");
        while (INPUT_FLAG){
            input = sc.next();
            if(input.equalsIgnoreCase("exit")){
                INPUT_FLAG = false;
                break;
            }
            else {
                try {
                    myList.add(Integer.parseInt(input));
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
        
        System.out.println("Max value = "+ myList.getMax());
        System.out.println("Min value = "+ myList.getMin());
        System.out.println("Average value = "+ myList.getAverage());
        myList.sort();
        System.out.println("Sorted Array (Ascending order) = "+ myList);
        myList.sortDescending();
        System.out.println("Sorted Array (Descending order) = "+ myList);
    }
}

/*

OUTPUT:

To exit input, type "exit"!
1
0
2
9
3
8
4
7
5
6
exit
Max value = 9
Min value = 0
Average value = 4.5
Sorted Array (Ascending order) = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
Sorted Array (Descending order) = [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]

*/

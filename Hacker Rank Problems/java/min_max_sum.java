import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class min_max_sum {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {

        int minPos = 0, maxPos = 0; long minSum=0, maxSum=0, sameSum = 0;
        boolean same = true;
        int picked = arr[0];
        for(int i =0; i<arr.length;i++)
        {
            if(arr[i] != picked)
            {same = false;
            break;}
        }
        if(!same)
        {
                 for(int i=0; i<arr.length; i++)
        {
            if(arr[i]>arr[maxPos])
            maxPos = i;
            if(arr[i]<arr[minPos])
            minPos = i;
        }

        for(int i=0; i<arr.length;i++)
        {
            if(i == maxPos)
            maxSum+=arr[i];
            else if(i == minPos)
            minSum+=arr[i];
            else{
                maxSum+=arr[i];
                minSum+=arr[i];
            }
        }
         System.out.print(minSum + " "+ maxSum);

        }
        else{
                for(int i=0;i<(arr.length-1);i++)
                sameSum+=arr[i];
                System.out.print(sameSum+" "+ sameSum);
        }
    
       
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}

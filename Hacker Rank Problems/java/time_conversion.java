import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.lang.String;

public class time_conversion {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
       
        int flag = s.indexOf(':');
        String rest=s.substring(flag,s.length()-2);
        String  hh, hh2, time24;
        String stamp = s.substring((s.length()-2),s.length());
        hh = s.substring(0,flag);
        if(stamp.equalsIgnoreCase("PM"))
        {
            if(Integer.parseInt(hh) == 12)
            hh2 = "12";
            else
            hh2 = String.valueOf(12 + Integer.parseInt(hh));
        }
        else{
            if(Integer.parseInt(hh) == 12)
            hh2 = "00";
            else
             hh2 = hh;

        }
       
        time24 = hh2+rest;
        return time24;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}

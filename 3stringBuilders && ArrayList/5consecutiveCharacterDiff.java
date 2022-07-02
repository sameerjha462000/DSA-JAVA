import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;
/*
    problem -- https://www.pepcoding.com/resources/online-java-foundation/string,-string-builder-and-arraylist/string-with-difference-of-every-two-consecutive-characters-official/ojquestion
*/
class Main{
    public static void main(String ...args){
        initializeIO();
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        System.out.println(diff(s));
    }
    public static String diff(String s){
        StringBuilder ans = new StringBuilder();
        ans.append(s.charAt(0));
        for(int i=1;i<s.length();i++){
            char prev = s.charAt(i-1);
            char curr = s.charAt(i);
            int diff = curr - prev;

            // if diff is negative we need to append '-' sign as well
            if(diff < 0)
            {
                // append '-' sign and then make diff positive so that
                // after the if we can append it in ans
                ans.append('-');
                diff = -diff;
            }
            // ans.append(diff + curr); this will give error because curr will get converted to int.
            ans.append(diff);
            ans.append(curr);
        }
        return ans.toString();
    }
    private static void initializeIO(){
        try 
        {
            System.setIn(new FileInputStream("input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
            System.setErr(new PrintStream(new FileOutputStream("error.txt")));
        } 
        catch (Exception e) 
        {
            System.err.println(e.getMessage());
        }
    }
}

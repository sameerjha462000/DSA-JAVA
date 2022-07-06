import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/*
    problem -- print subsequences without using arraylist(pick and non pick method)
*/
class Main{
    public static void main(String ...args){
        initializeIO();
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        printSubsequence(s);
    }

    public static void printSubsequence(String s){
        printSubsequenceHelper(s,"");
    }


    // This is the classic pick non pick algorithm
    public static void printSubsequenceHelper(String qsf,String asf){
        if(qsf.length() == 0)
        {
            System.out.println(asf);
            return;
        }

        char ch = qsf.charAt(0);

        printSubsequenceHelper(qsf.substring(1),asf+"-"); // do not include ch in asf
        printSubsequenceHelper(qsf.substring(1),asf+ch); // Include ch in asf
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

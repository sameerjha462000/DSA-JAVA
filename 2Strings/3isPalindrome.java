import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

class Main{
    public static void main(String ...args){
        initializeIO();
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        System.out.println(isPalindrome(s));
    }
    public static boolean isPalindrome(String s){
        // classic 2 pointer approach
        int start = 0;
        int end = s.length() - 1;

        while(start <= end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
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

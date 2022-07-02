import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

class Main{
    public static void main(String ...args){
        initializeIO();
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        palindromicSubstrings(s);
    }
    // Helper function to print all the palindromic substrings of a String 
    public static void palindromicSubstrings(String s){
        int n = s.length();

        // i goes from 0 to the last character which is s.length()-1
        for(int i=0;i<n;i++){
            // since i goes till last s.length()-1 so j must go till s.length()
            for(int j=i+1;j<n+1;j++){
                String ss = s.substring(i,j);
                if(isPalindromic(ss))
                    System.out.println(ss);
            }
        }
    }
    public static boolean isPalindromic(String s){
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

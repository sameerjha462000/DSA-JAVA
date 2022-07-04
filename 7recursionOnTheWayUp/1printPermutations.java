import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/*
    problem -- 
*/

class Main{
    public static void main(String ...args){
        initializeIO();
        Scanner scn = new Scanner(System.in);
        String s = scn.next();

        printPermutations(s);
    }

    public static void printPermutations(String s){
        int count = 2;
        if(count == 1)
            printPermutationsHelper1(s,"");
        else 
            printPermutationsHelper2(s,"");
    }

    public static void printPermutationsHelper1(String s, String asf){
        if(s.length() == 0)
        {
            System.out.println(asf);
            return;
        }

        StringBuilder sb = new StringBuilder(s);
        for(int i=0;i<s.length();i++){
            swap(sb,0,i);
            char ch = sb.charAt(0);
            printPermutationsHelper1(sb.toString().substring(1),asf+ch);
            swap(sb,0,i);
        }
    }

    public static void printPermutationsHelper2(String s, String asf){
        if(s.length() == 0)
        {
            System.out.println(asf);
            return;
        }

        StringBuilder sb = new StringBuilder(s);
        for(int i=0;i<sb.length();i++){
            // select the ith character
            char ch = sb.charAt(i);

            // delete this char
            sb.deleteCharAt(i);

            printPermutationsHelper2(sb.toString(),asf+ch);

            // Now add the character again at i

            sb.insert(i,ch);

            // This adding and deleting character at i is somewhat like backtracking...
        }
    }

    public static void swap(StringBuilder sb, int i,int j){
        char ch = sb.charAt(i);
        sb.setCharAt(i,sb.charAt(j));
        sb.setCharAt(j,ch);
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

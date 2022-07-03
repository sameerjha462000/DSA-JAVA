import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args){
        initializeIO();
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printDecreasing(n);
    }
    public static void printDecreasing(int n){
        // Base case (invalid)
        if(n == 0)
            return;
        System.out.println(n); // My work 
        
        printDecreasing(n-1); // faith
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

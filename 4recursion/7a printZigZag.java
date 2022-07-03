import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/*
    3 2 1 1 1 2 1 1 1 2 3 2 1 1 1 2 1 1 1 2 3 
*/
class Main{
    public static void main(String ...args){
        initializeIO();
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printZigZag(n);
    }
    public static void printZigZag(int n){
        // valid  base case
        if(n == 1){  
            System.out.print("1 1 1 ");         
            return;
        }
        System.out.print(n+" "); // My work
        printZigZag(n-1); // faith
        System.out.print(n+" "); // My work
        printZigZag(n-1); // faith
        System.out.print(n+" "); // My work

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

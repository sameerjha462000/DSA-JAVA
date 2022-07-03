import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/*
    1 <= x <= 10
    0 <= n <= 9
*/
class Main{
    public static void main(String ...args){
        initializeIO();
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printZigZag(n);
    }
    public static void printZigZag(int n){
        // invalid  base case
        if(n == 0)
            return;

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

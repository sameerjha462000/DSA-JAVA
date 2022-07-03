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
        int x = scn.nextInt();
        int n = scn.nextInt();
        System.out.println(powerLinear(x,n));
    }
    public static int powerLinear(int x,int n){
        if(n == 0) // valid base case
            return 1;
        return x * powerLinear(x, n-1); // My work plus faith returned
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

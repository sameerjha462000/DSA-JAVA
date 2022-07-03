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
        System.out.println(powerLogarithmic(x,n));
    }
    public static int powerLogarithmic(int x,int n){
        if(n == 0) // valid base case
            return 1;
        

        // consider 5 ^ 6 = (5 ^ 3) * (5 ^ 3)
        // consider 5 ^ 7 = (5 ^ 3) * (5 ^ 3) * 5
        int rres = powerLogarithmic(x, n/2); // faith 

        rres = rres * rres; // my work
        if(n % 2 == 1)
            rres  = rres * x; // my work when n is odd

        return rres;
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

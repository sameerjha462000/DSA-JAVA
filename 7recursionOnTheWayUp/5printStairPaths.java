import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/*
    problem -- print stair paths without using ArrayList...
*/
class Main{
    public static void main(String ...args){
        initializeIO();
        int n = (new Scanner(System.in)).nextInt();
        printStairPaths(n);
    }


    public static void printStairPaths(int n){
        int choice = 2;
        if(choice == 1)
            printStairPathsHelperReactive(n,"");
        else
            printStairPathsHelperProActive(n,"");
    }


    // This is the reactive approach
    public static void printStairPathsHelperReactive(int n, String asf){

        // Invalid base case
        if(n < 0)
            return;

        // Valid base case
        if(n == 0)
        {
            System.out.println(asf);
            return;
        }

        // just move and then dont think about the results, if it happens that you go to
        // wrong place I will prevent you ...
        printStairPathsHelperReactive(n-1,asf+"1");
        printStairPathsHelperReactive(n-2,asf+"2");
        printStairPathsHelperReactive(n-3,asf+"3");
    }

    // This is the proactive approach --- In this approach we never go to Invalid base case
    public static void printStairPathsHelperProActive(int n, String asf){

        // Valid base case
        if(n == 0)
        {
            System.out.println(asf);
            return;
        }

        if(n >= 1)
            printStairPathsHelperProActive(n-1,asf+"1");
        if(n >= 2)
            printStairPathsHelperProActive(n-2,asf+"2");
        if(n >= 3)
            printStairPathsHelperProActive(n-3,asf+"3");

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

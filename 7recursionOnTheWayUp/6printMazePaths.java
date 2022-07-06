import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/*
    problem -- print maze paths without ArrayList...
*/
class Main{
    public static void main(String ...args){
        initializeIO();
        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt(); // No of rows in the grid
        int nc = scn.nextInt(); // No of columns in the grid

        printMazePaths(nr,nc);
    }

    public static void printMazePaths(int nr, int nc){
        int choice = 2;
        if(choice == 1)
            printMazePathsHelperReactive(0,0,nr-1,nc-1,"");
        else
            printMazePathsHelperProActive(0,0,nr-1,nc-1,"");
    }


    // This is the reactive approach... In this we get invalid base cases...
    public static void printMazePathsHelperReactive(int sr,int sc,int er,int ec,String asf){

        // invalid base case
        if(sr > er || sc > ec)
            return;

        // valid base case
        if(sr == er && sc == ec)
        {
            System.out.println(asf);
            return ;
        }

        // Just move and dont think about the outcomes, if it happens that you go to a
        // wrong place just return back without doing anything...
        printMazePathsHelperReactive(sr,sc+1,er,ec,asf+"h");
        printMazePathsHelperReactive(sr+1,sc,er,ec,asf+"v");
    }

    // This is the ProActive approach first think and then move... In this way you will never get to invalid base case
    public static void printMazePathsHelperProActive(int sr,int sc,int er,int ec,String asf){

        // Valid base case
        if(sr == er && sc == ec)
        {
            System.out.println(asf);
            return;
        }

        // first think then move...
        if(sc+1 <= er)
            printMazePathsHelperProActive(sr,sc+1,er,ec,asf+"h");
        
        // first think then move...
        if(sr+1 <= ec)
            printMazePathsHelperProActive(sr+1,sc,er,ec,asf+"v");
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

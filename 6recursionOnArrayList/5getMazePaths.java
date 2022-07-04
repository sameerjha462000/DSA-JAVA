import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/*
    problem -- This is keypad combination problem...
*/

class Main{
    public static void main(String ...args){
        initializeIO();
        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt();
        int nc = scn.nextInt();

        getMazePaths(nr,nc);
    }

    public static void getMazePaths(int nr,int nc){
        int choice = 2;
        ArrayList<String> ans;
        if(choice == 1)
            ans = getMazePathsHelper1(0, 0, nr - 1, nc - 1);
        else 
            ans = getMazePathsHelper2(0, 0, nr-1, nc-1);
        System.out.println(ans);
    }

    // Take the proactive approach
    public static ArrayList<String> getMazePathsHelper1(int sr,int sc,int er,int ec){


        // In proactive approach it is not possible to go to invalid base case
        // But what is the valid base case
        if(sr == er && sc == ec)
        {
            ArrayList<String> base = new ArrayList<>();
            base.add(""); // should i add this? yes, but why ? because even when you are already at the destination that would itself be counted as 1 way
            return base;
        }

        ArrayList<String> hpath = new ArrayList<>();
        ArrayList<String> vpath = new ArrayList<>();
        if(sc+1<=ec)
            hpath = getMazePathsHelper1(sr,sc+1,er,ec);
        if(sr+1<=er)
            vpath = getMazePathsHelper1(sr+1,sc,er,ec);

        ArrayList<String> ans = new ArrayList<>();
        for(String s : hpath)
            ans.add("h"+s);
        for(String s : vpath)
            ans.add("v"+s);

        return ans;
    }

    // Take the reactive approach
    public static ArrayList<String> getMazePathsHelper2(int sr,int sc,int er,int ec){
        // Since we have taken the reactive approach so we also need to handle invalid base cases as well
        if(sr > er || sc > ec)
            return new ArrayList<String>();

        // valid base case
        if(sr == er && sc == ec)
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        // just take the steps forward and will think afterwards
        ArrayList<String> hpath = getMazePathsHelper2(sr,sc+1,er,ec);
        ArrayList<String> vpath = getMazePathsHelper2(sr+1,sc,er,ec);

        ArrayList<String> ans = new ArrayList<>();

        for(String s : hpath)
            ans.add("h"+s);
        for(String s : vpath)
            ans.add("v"+s);

        return ans;
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

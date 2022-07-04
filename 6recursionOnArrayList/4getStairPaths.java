import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/*
    problem -- This is get stair paths...
*/

class Main{
    public static void main(String ...args){
        initializeIO();
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        getStairPaths(n);
    }

    public static void getStairPaths(int n){
        int choice = 2;
        ArrayList<String> ans = null;
        if(choice == 1)
            ans = getStairPathsHelper1(n);
        else 
            ans = getStairPathsHelper2(n);
        System.out.println(ans);
    }

    // reactive approach
    public static ArrayList<String> getStairPathsHelper2(int n){

        // Invalid base case
        if(n < 0)
            return new ArrayList<String>();

        // Valid base case
        if(n == 0)
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        // Just take the step and dont think about the outcomes 
        // There might be two outcomes,-- you might reach the invalid base case (n < 0) 
        // or you might reach a valid base case -- like when n == 0
        ArrayList<String> rresOne = getStairPathsHelper2(n-1);
        ArrayList<String> rresTwo = getStairPathsHelper2(n-2);
        ArrayList<String> rresThree = getStairPathsHelper2(n-3);

        ArrayList<String> ans = new ArrayList<>();
        for(String s : rresOne)
            ans.add("1"+s);
        for(String s : rresTwo)
            ans.add("2"+s);
        for(String s : rresThree)
            ans.add("3"+s);

        return ans;
    }

    // Proactive way of solving this problem
    public static ArrayList<String> getStairPathsHelper1(int n){
        if(n == 0)
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> rresOne = new ArrayList<>();
        ArrayList<String> rresTwo = new ArrayList<>();
        ArrayList<String> rresThree = new ArrayList<>();


        if(n >= 1)
            rresOne = getStairPathsHelper1(n-1);
        if(n >= 2)
            rresTwo = getStairPathsHelper1(n-2);
        if(n >= 3)
            rresThree = getStairPathsHelper1(n-3);

        // Now time to store the result in our finalAns
        ArrayList<String> ans = new ArrayList<>();

        for(String s : rresOne)
            ans.add(s+"1");
        for(String s : rresTwo)
            ans.add(s+"2");
        for(String s : rresThree)
            ans.add(s+"3");

        // same thing but in this the first step is taken by you and then recursion is called

        // for(String s : rresOne)
        //     ans.add("1"+s);
        // for(String s : rresTwo)
        //     ans.add("2"+s);
        // for(String s : rresThree)
        //     ans.add("3"+s);

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

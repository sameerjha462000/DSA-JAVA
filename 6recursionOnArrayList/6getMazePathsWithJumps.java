import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/*
    problem -- get maze paths with jumps...
*/

class Main{
    public static void main(String ...args){
        initializeIO();
        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt();
        int nc = scn.nextInt();

        getMazePathsWithJumps(nr,nc);
    }

    public static void getMazePathsWithJumps(int nr, int nc){
        ArrayList<String> ans = new ArrayList<>();
        getMazePathsWithJumpsHelper(0,0,nr-1,nc-1,"",ans);
        System.out.println(ans);
    }
    
    // Proactive code (There would be no base case)
    public static void getMazePathsWithJumpsHelper(int sr,int sc,int er,int ec,String asf,ArrayList<String> ans){

        // Valid base case
        if(sr == er && sc == ec){
            ans.add(asf);
            return;
        }

        // Horizontal jump
        for(int i=1;i<=ec-sc;i++){
            getMazePathsWithJumpsHelper(sr,sc+i,er,ec,asf+"h"+i,ans);
        }

        // Vertical jump
        for(int i=1;i<=er-sr;i++){
            getMazePathsWithJumpsHelper(sr+i,sc,er,ec,asf+"v"+i,ans);
        }

        // Diagonal jump
        for(int i=1;i<=min(er-sr,ec-sc);i++){
            getMazePathsWithJumpsHelper(sr+i,sc+i,er,ec,asf+"d"+i,ans);
        }
    }

    public static int min(int a, int b){
        if(a <= b)
            return a;
        return b;
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

import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;


// problem -- https://nados.io/question/spiral-display
class Main{
    public static void main(String ...args){
        initializeIO();

        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt();
        int nc = scn.nextInt();

        int[][] nums = new int[nr][nc];

        for(int i=0;i<nr;i++){
            for(int j=0;j<nc;j++){
                nums[i][j] = scn.nextInt();
            }
        }
        spiralDisplay(nums);
    }
    private static void spiralDisplay(int[][] nums){
        int nr = nums.length;
        int nc = nums[0].length;

        // Initialize the starting row pointers and columns and ending row and column
        // pointers
        int sr = 0;
        int sc = 0;
        int er = nr-1;
        int ec = nc-1;

        // count the total number of elements
        int tne = nr * nc;

        while(tne >= 0){
            // print in top to down fashion
            for(int r = sr,c = sc;r <= er && tne > 0;++r){
                System.out.print(nums[r][c]+" ");

                // after printing an element decrease total number of elements to be
                // printed by 1
                --tne;
            }
            // print in left to right fashion
            for(int c = sc + 1,r = er;c <= ec && tne > 0;++c){
                System.out.print(nums[r][c]+" ");
                --tne;
            }
            // print in down to top fashion
            for(int r = er - 1,c = ec;r >= 0 && tne > 0;--r){
                System.out.print(nums[r][c]+" ");
                --tne;
            }
            // print in right to left fashion
            for(int c = ec-1,r = sr;c >= sc + 1 && tne > 0;--c){
                System.out.print(nums[r][c]+" ");
                --tne;
            }

            // after printing update the pointers
            sr++;
            sc++;
            er--;
            ec--;

        }
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

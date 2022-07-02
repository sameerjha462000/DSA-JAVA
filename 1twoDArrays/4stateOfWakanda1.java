import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;


// problem -- https://www.pepcoding.com/resources/online-java-foundation/2d-arrays/wakanda-1-official/ojquestion
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

        stateOfWakanda(nums);
    }

    public static void stateOfWakanda(int[][] nums){
        int nr = nums.length;
        int nc = nums[0].length;

        // iterate over columns

        for(int col=0;col<nc;col++){
            if((col&1)==0){
                // if col no is even then print in top to bottom
                for(int i=0;i<nr;i++){
                    System.out.print(nums[i][col]+" ");
                }
            }else{
                // if col no is odd then print in bottom to top
                for(int i=nr-1;i>=0;--i){
                    System.out.print(nums[i][col]+" ");
                }
            }

            // after printing a column print a newline
            System.out.println();
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

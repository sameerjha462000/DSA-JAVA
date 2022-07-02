import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/*
    problem -- https://www.pepcoding.com/resources/online-java-foundation/2d-arrays/diagonal-traversal-official/ojquestion
*/
class Main{
    public static void main(String ...args){
        initializeIO();

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] nums = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                nums[i][j] = scn.nextInt();
            }
        }

        stateOfWakanda2(nums);
    }

    public static void stateOfWakanda2(int[][] nums){
        int n = nums.length;

        int diff = 0;
        while(diff != n){
            int row = 0;
            int col = row + diff;
            while(col != n){
                System.out.print(nums[row][col]+" ");
                ++row;
                ++col;
            }
            ++diff;
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

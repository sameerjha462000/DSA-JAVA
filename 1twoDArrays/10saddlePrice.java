import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/*
    problem -- https://www.pepcoding.com/resources/online-java-foundation/2d-arrays/saddle-price-official/ojquestion
*/
/*
  CONJECTURE -- saddle price of a matrix, if it exists, is unique.(Will think some day)
*/
class Main{
    public static void main(String ...args){
        initializeIO();

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] nums = new int[n][n];

        fill(nums, scn);

        int ans = saddlePrice(nums);
        if(ans == -1)
            System.out.println("Invalid input");
        else
            System.out.println(ans);
    }
    private static class pair{
        int first;
        int second;

        pair(){

        }
        pair(int first, int second){
            this.first = first;
            this.second = second;
        }
        @Override
        public String toString(){
            return "<" + first + ", " + second + ">";
        }
    }
    public static int saddlePrice(int[][] nums){
        int n = nums.length;
        int ans = -1;
        // In each row find minimum
        for(int row = 0;row < n;row++){
            pair p = min(nums,row);
            // System.out.println(p);

            // check whether p.first is max in its entire columns which is p.second
            if(tellMe(nums,p.second,p.first)){
                ans = p.first;
                break;
            }
        }
        return ans;
    }
    public static boolean tellMe(int[][] nums, int col, int val){
        // check whether max(nums,col) == val
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < n;i++){
            if(nums[i][col] > max)
                max = nums[i][col];
        }

        if(max == val)
            return true;
        return false;
    }
    public static pair min(int[][] nums,int row){
        int n = nums.length;
        pair ans = new pair(Integer.MAX_VALUE,-1);
        for(int i = 0;i < n;i++){
            if(nums[row][i] < ans.first){
                ans.first = nums[row][i];
                ans.second = i;
            }
        }
        return ans;
    }
    public static void fill(int[][] nums, Scanner scn){
        int nr = nums.length;
        int nc = nums[0].length;

        for(int i=0;i<nr;i++){
            for(int j=0;j<nc;j++){
                nums[i][j] = scn.nextInt();
            }
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

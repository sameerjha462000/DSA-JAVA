import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/*
    Rotate a given square matrix by 90 degrees clockwise.
    Note : You are required to do this in O(1) space
*/
class Main{
    public static void main(String ...args){
        initializeIO();
        Scanner scn = new Scanner(System.in);
        int[][] nums = {{11, 12, 13, 14},
                        {21, 22, 23, 24},
                        {31, 32, 33, 34},
                        {41, 42, 43, 44}};

        rotate(nums);
        print(nums);
    }
    public static void rotate(int[][] nums){
        // First take the transpose of matrix 
        transpose(nums);

        // After transpose swap the columns using classic 2 pointer approach
        int start = 0;
        int end = nums.length - 1; // since no of columns == no of rows
        while(start <= end){
            // for swapping columns at index start and index end
            swap(nums,start,end);
            start++;
            end--;
        }
    }

    // Helper function to swap the columns at two index
    public static void swap(int[][] nums, int start,int end){
        // for this we will have to swap their each and every element
        int n = nums.length;
        for(int i=0;i<n;i++){
            // swap the elements at nums[i][start] and nums[i][end]
            int temp = nums[i][start];
            nums[i][start] = nums[i][end];
            nums[i][end] = temp;
        }
        // This function takes O(number of rows) time.
    }

    public static void print(int[][] nums){
        for(int[] vals : nums){
            System.out.println(Arrays.toString(vals));
        }
    }

    //Helper function to transpose the matrix
    public static void transpose(int[][] nums){
        // For transpose just mirror the matrix by its diagonal
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                // swap nums[i][j] with nums[j][i]
                int temp = nums[i][j];
                nums[i][j] = nums[j][i];
                nums[j][i] = temp;
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
/*
    output:
    [41, 31, 21, 11]
    [42, 32, 22, 12]
    [43, 33, 23, 13]
    [44, 34, 24, 14]
*/

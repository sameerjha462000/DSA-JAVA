import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

class Main{
    public static void main(String ...args){
        initializeIO();
        Scanner scn = new Scanner(System.in);

        // Taking two 2D arrays as input 
        int[][] numsOne = readIntArray(scn);
        int[][] numsTwo = readIntArray(scn);

        int[][] ans = multiply(numsOne,numsTwo);
        if(ans != null){
            print(ans);
        }else{
            System.out.println("Matrices non conformable...");
        }
    }

    // Function to multiply two 2D arrays
    public static int[][] multiply(int[][] numsOne,int[][] numsTwo){
        int nrOne = numsOne.length;
        int ncOne = numsOne[0].length;

        // dimensions of second array
        int nrTwo = numsTwo.length;
        int ncTwo = numsTwo[0].length;

        if(ncOne != nrTwo)
            return null;

        // else matrices are compatible for multiplication so multiply them
        int[][] ans = new int[nrOne][ncTwo];

        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                // (i, j) element of ans is simply the vector product of
                // ith row of numsOne and jth column of numsTwo
                ans[i][j] = multiplyHelper(numsOne,i,numsTwo,j);
            }
        }
        // return the reference of ans
        return ans;
    }
    public static int multiplyHelper(int[][] numsOne,int i,int[][] numsTwo,int j){
        int ans = 0;
        int n = numsOne[0].length; // same as numsTwo.length
        for(int x=0;x<n;x++){
            ans += (numsOne[i][x] * numsTwo[x][j]);
        }
        return ans;
    }
    // Helper function to return the reference of a 2D array
    public static int[][] readIntArray(Scanner scn){
        int nr = scn.nextInt();
        int nc = scn.nextInt();

        int[][] nums = new int[nr][nc];
        for(int i=0;i<nr;i++){
            for(int j=0;j<nc;j++){
                nums[i][j] = scn.nextInt();
            }
        }

        // return the reference of the 2D array
        return nums;
    }
    // Helper funtion to print the 2D array
    public static void print(int[][] nums){
        // This is range based for loop
        for(int[] vals : nums){
            System.out.println(Arrays.toString(vals));
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

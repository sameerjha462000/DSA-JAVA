import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/*
    problem -- Ring rotate
*/
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

        int s = scn.nextInt();
        int r = scn.nextInt();

        ringRotate(nums,s,r);
        print(nums);

    }

    public static void print(int[][] nums){
        int nr = nums.length;
        int nc = nums[0].length;
        for(int i=0;i<nr;i++){
            for(int j=0;j<nc;j++){
                System.out.print(nums[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void ringRotate(int[][] nums,int shellNumber,int rotation){
        // Extract the sth shell
        int nr = nums.length;
        int nc = nums[0].length;

        int sr = 0, sc = 0, er = nr - 1, ec = nc - 1;
        // for outer most shell this values hold and shell number is 1
        for(int times = 1;times < shellNumber; times++){
            ++sr;
            ++sc;
            --er;
            --ec;
        }
        // Now store this shell in an array
        // but what is the length of array??
        int length = (er - sr + 1 + ec - (sc + 1) + 1 + (er - 1) - sr + 1 + (ec - 1) - (sc + 1) + 1);
        int[] shellVals = new int[length];

        // Now fill the shell using spiral display
        int idx = 0;
        for(int r = sr,c = sc;r <= er;++r){
            shellVals[idx++] = nums[r][c];
        }
            
        for(int c = sc + 1,r = er;c <= ec;++c){
            shellVals[idx++] = nums[r][c];
        }
        
        for(int r = er - 1,c = ec;r >= sr;--r){
            shellVals[idx++] = nums[r][c];
        }
            
        for(int c = ec-1,r = sr;c >= sc + 1;--c){
            shellVals[idx++] = nums[r][c];
        }
        // Rotate it r times anticlockwise
        rotate(shellVals,rotation);
        // fill the sth shell again with rotated shell
        int index = 0;
        for(int r = sr,c = sc;r <= er;++r){
            nums[r][c] = shellVals[index++];
        }
            
        for(int c = sc + 1,r = er;c <= ec;++c){
            nums[r][c] = shellVals[index++];
        }
            
        for(int r = er - 1,c = ec;r >= sr;--r){
            nums[r][c] = shellVals[index++];
        }
            
        for(int c = ec-1,r = sr;c >= sc + 1;--c){
            nums[r][c] = shellVals[index++];
        }

    }

    // Helper function to rotate the shellVals by r
    public static void rotate(int[] shellVals,int rotation){
        int n = shellVals.length;

        rotation = rotation % n;
        if(rotation < 0)
            rotation += n;
        reverse(shellVals, 0,n - rotation - 1);
        reverse(shellVals, n - rotation, n - 1);
        reverse(shellVals, 0, n - 1);

    }

    // Helper function to reverse the array using 2 pointer approach
    public static void reverse(int[] shellVals,int start, int end){
        int i = start;
        int j = end;
        while(i <= j){
            // swap shellVals[start] and shellVals[end]
            int temp = shellVals[i];
            shellVals[i] = shellVals[j];
            shellVals[j] = temp;
            i++;
            j--;
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

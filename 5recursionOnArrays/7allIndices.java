import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/*
    problem -- find all indices of x in nums
*/

class Main{
    public static void main(String ...args){
        initializeIO();
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = scn.nextInt();
        }
        int x = scn.nextInt();

        allIndices(nums,x);
    }

    public static void allIndices(int[] nums,int x){

        // int[] ans = allIndicesHelper2(nums,x,nums.length-1,0);
        // int[] ans = allIndicesHelper1(nums,x,0,0);

        int choice = 1;
        int[] ans = null;

        if(choice == 1)
            ans = allIndicesHelper1(nums,x,0,0);
        else
            ans = allIndicesHelper2(nums,x,nums.length-1,0);


        if(ans == null)
            System.out.println("Element not found...");
        else
        {
            System.out.print("Element found at : ");
            Arrays.sort(ans);
            System.out.println(Arrays.toString(ans));
        }
        
    }

    public static int[] allIndicesHelper1(int[] nums,int x,int idx,int fsf){
        // Invalid base case
        if(idx == nums.length)
        {
            if(fsf == 0)
                return null;
            else{
                int[] indicesOfx = new int[fsf];
                return indicesOfx;
            }
        }

        if(nums[idx] == x)
            ++fsf;

        int[] rres = allIndicesHelper1(nums,x,idx+1,fsf); // faith

        if(rres == null)
            return null;
        if(nums[idx] == x)
            rres[--fsf] = idx;

        return rres;
    }

    public static int[] allIndicesHelper2(int[] nums,int x, int idx,int fsf){
        // Invalid base case
        if(idx == -1){
            if(fsf == 0)
                return null;
            else
            {
                int[] base = new int[fsf];
                return base;
            }
        }

        if(nums[idx] == x)
            ++fsf;

        int[] rres = allIndicesHelper2(nums,x,idx-1,fsf); // faith

        if(rres == null)
            return null;
        if(nums[idx] == x)
        {
            rres[--fsf] = idx;
        }

        return rres;
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

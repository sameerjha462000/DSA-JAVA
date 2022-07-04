import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/*
    problem -- find max of an array...
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
        System.out.println(max(nums));
    }

    public static int max(int[] nums){
        int ans = -1;
        int choice = 4;
        if(choice == 1)
            ans = maxHelper1(nums,0);
        else if(choice == 2)
            ans = maxHelper2(nums,0);
        else if(choice == 3)
            ans = maxHelper3(nums,nums.length-1);
        else
            ans = maxHelper4(nums,nums.length-1);
        return ans;
    }

    public static int maxHelper1(int[] nums,int idx){
        // invalid base case
        if(idx == nums.length)
            return Integer.MIN_VALUE;

        int ans = maxHelper1(nums,idx+1); // faith

        if(ans >= nums[idx])
            return ans;
        return nums[idx];
    }

    public static int maxHelper2(int[] nums,int idx){
        // valid base case
        if(idx == nums.length-1)
            return nums[idx];

        int ans = maxHelper2(nums,idx+1); // faith

        if(ans >= nums[idx])
            return ans;
        return nums[idx];
    }

    public static int maxHelper3(int[] nums,int idx){
        // invalid base case
        if(idx == -1)
            return Integer.MIN_VALUE;
        int ans = maxHelper3(nums,idx-1); // faith

        if(ans >= nums[idx])
            return ans;
        return nums[idx];
    }

    public static int maxHelper4(int[] nums,int idx){
        //valid base case
        if(idx == 0)
            return nums[idx];

        int ans = maxHelper4(nums,idx-1); // faith

        if(ans >= nums[idx])
            return ans;
        return nums[idx];
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

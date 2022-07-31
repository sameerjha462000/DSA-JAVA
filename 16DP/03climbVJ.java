import static java.lang.System.*;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Stack;
import java.util.Queue;
import java.util.HashMap;

class dp{
    
    public static void main(String[] args) throws IOException{
        initializeIO();

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] nums = new int[n];

        for(int i = 0;i < n;i++)
        {
            nums[i] = scn.nextInt();
        }

        System.out.println(climbVJ(nums));
    }

    private static int climbVJ(int[] nums)
    {
        int start = 0;

        return climbVJHelper(nums,start);
    }

    private static int climbVJHelper(int[] nums,int start)
    {
        int N = nums.length;

        // I want to reach from 0 to Nth stair

        if(start > N)
            return 0;

        if(start == N)
            return 1;

        if(nums[start] == 0)
            return 0; // This is dead floor

        int ans = 0;
        for(int steps = 1; steps <= nums[start] ; steps++)
        {
            int currFloor = start+steps;
            
            if(currFloor == nums.length)
            {
                ans += 1;
                break;
            }

            if(nums[currFloor] == 0)
                continue; // As this is a dead floor
            ans += climbVJHelper(nums,currFloor); // No of ways to move from currFloor till N
        }

        return ans;
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

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

        System.out.println(climb(n)); // counts the number of ways to reach from the stair No 0 to stair no n

        int[] dp = new int[n+1];

        Arrays.fill(dp,-1);

        System.out.println(climbTopDown(n,dp));
        System.out.println(climbBottomUp(n));
        System.out.println(climbBottomUpOptimized(n));
    }

    private static int climb(int n)
    {
        if(n < 0)
            return 0;

        if(n == 0)
            return 1; // from 0 --> to 0 #number of ways = 1

        return climb(n-1)+climb(n-2)+climb(n-3);
    }

    private static int climbTopDown(int n,int[] dp)
    {
        // dp[i] = number of ways to go from 0th stair to nth stair
        if(n < 0)
            return 0;

        if(n == 0)
            return dp[n] = 1;

        if(dp[n] != -1)
            return dp[n];

        return dp[n] = climbTopDown(n-1,dp)+climbTopDown(n-2,dp)+climbTopDown(n-3,dp);
    }

    private static int climbBottomUp(int n)
    {
        int[] dp = new int[n+1];

        // dp[i] denotes the number of ways to move from 0th stair to nth stair using 1 2 or 3 steps

        dp[0] = 1;

        for(int i = 1; i <= n;i++)
        {
            int op1 = (i-1 >= 0) ? (dp[i-1]):(0);
            int op2 = (i-2 >= 0) ? (dp[i-2]):(0);
            int op3 = (i-3 >= 0) ? (dp[i-3]):(0);

            dp[i] = op1 + op2 + op3;
        }

        return dp[n];
    }

    private static int climbBottomUpOptimized(int n)
    {
        int[] dp = new int[4];

        dp[0] = 1;

        for(int i = 1;i <= n;i++)
        {
            if(i <= 2)
            {
                int op1 = (i-1 >= 0) ? (dp[i-1]):(0);
                int op2 = (i-2 >= 0) ? (dp[i-2]):(0);
                int op3 = (i-3 >= 0) ? (dp[i-3]):(0);

                dp[i] = op1 + op2 + op3;
            }else{
                dp[3] = dp[2]+dp[1]+dp[0];

                dp[0] = dp[1];
                dp[1] = dp[2];
                dp[2] = dp[3];
            }
        }

        return dp[3];
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

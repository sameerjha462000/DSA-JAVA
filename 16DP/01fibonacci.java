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


        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(fibTopDown(n,dp));

        System.out.println(fib(n));
        System.out.println(fibBottomUp(n));
        System.out.println(fibBottomUpOptimized(n));

        
    }

    private static int fib(int n)
    {

        if(n == 0 || n == 1)
            return n;

        return fib(n-1)+fib(n-2);
    }

    private static int fibTopDown(int n,int[] dp)
    {

        if(n == 0 || n == 1)
            return dp[n] = n;

        if(dp[n] != -1)
        {
            return dp[n];
        }

        return dp[n] = fibTopDown(n-1,dp)+fibTopDown(n-2,dp);
    }

    private static int fibBottomUp(int n)
    {
        int[] dp = new int[n+1];

        dp[1] = 1;

        for(int i = 2;i <= n ;i++)
        {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    private static int fibBottomUpOptimized(int n)
    {
        int[] dp = new int[3];

        dp[1] = 1;

        for(int i = 2; i <= n;i++)
        {
            dp[2] = dp[0]+dp[1];

            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
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

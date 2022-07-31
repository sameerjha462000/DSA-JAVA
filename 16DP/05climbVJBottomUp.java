    private static int climbVJBottomUp(int[] nums)
    {
        int N = nums.length;

        int[] dp = new int[N+1]; // 0 to N

        // dp[i] = # of ways to go from i to Nth stair

        Arrays.fill(dp,0);

        dp[N] = 1; // as the # of ways to go from N to N is 1

        // fill the dp arrays in the reverse direction

        for(int i = N-1; i >= 0 ;i--)
        {
            int maxSteps = nums[i];

            if(maxSteps == 0)
            {
                // This is a dead floor so dp[i] = 0;
                dp[i] = 0;
            }else{
                for(int steps = 1; steps <= maxSteps; steps++)
                {
                    // dp[i] += dp[i+step]
                    if(i+steps == N)
                    {
                        dp[i] += 1;
                        break;
                    }

                    if(dp[i+steps] != 0)
                    {
                        dp[i] += dp[i+steps];
                    }

                }
            }
        }

        return dp[0];
    }

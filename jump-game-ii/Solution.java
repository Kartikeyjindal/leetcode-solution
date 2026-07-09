class Solution {
    int[] dp;

    public int jump(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(0, nums);
    }

    public int solve(int index, int[] nums) 
    {
        if (index >= nums.length - 1) return 0;
        if (dp[index] != -1) return dp[index];

        int minjumps = Integer.MAX_VALUE;

        for (int step = 1; step <= nums[index]; step++) 
        {
            int nextindex = index + step;
            if (nextindex < nums.length) 
            {
                int result = solve(nextindex, nums);
                if (result != Integer.MAX_VALUE) 
                {
                    minjumps = Math.min(minjumps, 1 + result);
                }
            }
        }

        return dp[index] = minjumps;
    }
}

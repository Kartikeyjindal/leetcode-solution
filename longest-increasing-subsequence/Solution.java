class Solution 
{
    int [][]dp;
    public int lengthOfLIS(int[] nums) 
    {
        dp=new int[nums.length][nums.length+1];
        for (int[] row : dp) 
        {
            Arrays.fill(row, -1);
        }
        return solve(0,-1,nums);
    }

    public int solve(int i,int prev,int []nums)
    {
        if(i>=nums.length)
        {
            return 0;
        }
        if(dp[i][prev+1]!=-1)
        {
            return dp[i][prev+1];
        }
        int take=0;
        if(prev ==-1 || nums[prev]<nums[i])
        {
            take=1+solve(i+1,i,nums);
        }
        int skip=solve(i+1,prev,nums);

        return dp[i][prev+1]=Math.max(take,skip);
    }
}
class Solution
{
    public long maxAlternatingSum(int[] nums) 
    {
        int n=nums.length;
        long [][]dp=new long[n+1][2];
        int even=0;
        int odd=1;

        for(int i=1;i<=n;i++)
        {
            dp[i][even]=Math.max(dp[i-1][odd]+nums[i-1],dp[i-1][even]);
            dp[i][odd]=Math.max(dp[i-1][even]-nums[i-1],dp[i-1][odd]);
        }
        return Math.max(dp[n][odd],dp[n][even]);
    }
}
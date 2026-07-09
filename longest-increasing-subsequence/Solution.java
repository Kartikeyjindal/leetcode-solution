class Solution 
{
    public int n;
    public int [][]dp=new int[2501][2501];
    public int lengthOfLIS(int[] nums) 
    {
        n=nums.length;
        for(int i = 0; i <= n; i++)
        {
            Arrays.fill(dp[i], -1);
        }
       return solve(nums,0,-1);
    }

    public int solve(int [] nums,int s,int p)
    {
        if(p != -1 && dp[s][p] != -1)
        {
            return dp[s][p];
        }
        if(s>=n)
        {
            return 0;
        }
        int take=0;
        if(p == -1 || nums[s]>nums[p])
        {
            take=1+solve(nums,s+1,s);
        }
        int skip=solve(nums,s+1,p);
        if(p !=-1)
        {
            return dp[s][p]=Math.max(take,skip);
        }
        return Math.max(take,skip);
    }
}
class Solution 
{
    long [][]dp;
    public long maxAlternatingSum(int[] nums) 
    {
        int n=nums.length;
        dp=new long[nums.length][2];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return solve(0,1,nums);
    }

    public long solve(int i,int flag ,int[]nums)
    {
        if(i>=nums.length)
        {
            return 0;
        }
        if(dp[i][flag]!=-1)
        {
            return dp[i][flag];
        }
        long skip=solve(i+1,flag,nums);
        long pick=0;

        if(flag==1)
        {
            pick=nums[i]+solve(i+1,0,nums);
        }
        else
        {
            pick=-nums[i]+solve(i+1,1,nums);
        }

        return dp[i][flag]=Math.max(skip,pick);

    }
}
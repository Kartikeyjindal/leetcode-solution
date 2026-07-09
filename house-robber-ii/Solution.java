class Solution 
{
    int []dp;
    public int rob(int[] nums) 
    {
        int n=nums.length;
        if(n==1)
        {
            return nums[0];
        }

        int []n1=new int[n-1];
        int []n2=new int[n-1];
        for(int i=0;i<n-1;i++)
        {
            n1[i]=nums[i];
        }
        for(int i=1;i<n;i++)
        {
            n2[i-1]=nums[i];
        }
        dp=new int[n];
        Arrays.fill(dp,-1);
        int ans1=solve(0,n1);

        dp=new int[n];
        Arrays.fill(dp,-1);
        int ans2=solve(0,n2);

        return Math.max(ans1,ans2);
    }

    public int solve(int i,int []nums)
    {
        if(i>=nums.length)
        {
            return 0;
        }
        if(dp[i]!=-1)
        {
            return dp[i];
        }

        int cur=nums[i]+solve(i+2,nums);
        int next=solve(i+1,nums);
        return dp[i]=Math.max(cur,next);
    }
}
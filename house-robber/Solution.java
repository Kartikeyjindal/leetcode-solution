class Solution 
{
    public int rob(int[] nums) 
    {
        if(nums.length == 1)
        {
            return nums[0];
        }

        int []dp=new int [nums.length+1];
        dp[0]=0;
        dp[1]=nums[0];

        for(int i=2;i<=nums.length;i++)
        {
            int skip=dp[i-1];
            int steal=dp[i-2]+nums[i-1];

            dp[i]=Math.max(skip,steal);
        }
        return dp[nums.length];
    }
}
class Solution 
{
    public int firstStableIndex(int[] nums, int k) 
    {
        int n=nums.length;
        if(n==0)
        {
            return -1;
        }

        int[]mine=new int[n];
        mine[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--)
            {
                mine[i]=Math.min(nums[i],mine[i+1]);
            }
        int currmax=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
            {
                currmax=Math.max(currmax,nums[i]);
                if(currmax-mine[i]<=k)
                {
                    return i;
                }
            }
        return -1;
    }
}
class Solution 
{
    public int maxAbsoluteSum(int[] nums) 
    {
        if(nums.length==0)
        {
            return 0;
        }
        int currentsum=0;
        int maxsum=Integer.MIN_VALUE;
        int minsum=Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++)
        {
            currentsum+=nums[i];
            maxsum=Math.max(maxsum,currentsum);
            if(currentsum <0)
            {
                currentsum=0;
            }
        }
        currentsum=0;
        for(int i=0;i<nums.length;i++)
        {
            currentsum+=nums[i];
            minsum=Math.min(currentsum,minsum);
            if(currentsum>0)
            {
                currentsum=0;
            }
        }
        minsum=Math.abs(minsum);
        int ans=Math.max(minsum,maxsum);
        return ans;
    }
}
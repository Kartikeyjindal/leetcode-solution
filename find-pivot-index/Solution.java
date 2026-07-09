class Solution 
{
    public int pivotIndex(int[] nums) 
    {
        int n=nums.length;
        int sum=0;
        for(int i:nums)
        {
            sum+=i;
        }
        int currsum=0;
        for(int i=0;i<n;i++)
        {
            if(sum-nums[i]-currsum==currsum)
            {
                return i;
            }
            currsum+=nums[i];

        }
        return -1;
    }
}
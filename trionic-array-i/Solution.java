class Solution 
{
    public boolean isTrionic(int[] nums) 
    {
        int n=nums.length;
        if(n==3)
        {
            return false;
        }
        int idx=-1;
        for(int i=0;i<n-2;i++)
        {
            if(nums[i]>=nums[i+1])
            {
                idx=i;
                break;
            }
        }
        if(idx==0||idx==-1)
        {
            return false;
        }
        for(int i=idx;i<n-1;i++)
        {
            if(nums[i]<=nums[i+1])
            {
                idx=i;
                break;
            }
        }
        if(idx==0||idx==-1)
        {
            return false;
        }
        for(int i=idx;i<n-1;i++)
        {
            if(nums[i]>=nums[i+1])
            {
                return false;
            }
        }
        return true;
    }
}
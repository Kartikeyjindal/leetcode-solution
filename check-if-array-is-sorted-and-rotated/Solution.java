class Solution 
{
    public boolean check(int[] nums) 
    {
        int n=nums.length;
        int peek=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]>nums[(i+1)%n])
            {
                peek++;
            }
        }
        if(peek>1)
        {
            return false;
        }
        return true;
    }
}
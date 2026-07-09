class Solution 
{
    public int minimumCost(int[] nums) 
    {
        int a=Integer.MAX_VALUE;
        int b=Integer.MAX_VALUE;
        int n=nums.length;
        for(int i=1;i<n;i++)
        {
           if(nums[i]<a)
           {
            b=a;
            a=nums[i];
           }
           else if(nums[i]<b)
           {
            b=nums[i];
           }
        }
        return nums[0]+a+b;
    }
}
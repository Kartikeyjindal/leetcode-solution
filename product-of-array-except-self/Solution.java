class Solution 
{
    public int[] productExceptSelf(int[] nums) 
    {
        int n=nums.length;
        int newarr[]=new int[n];
        
        for (int i=0;i<n;i++) 
        {
            newarr[i] = 1;
        }
        int left=1;
        for(int i=0;i<n;i++)
        {
            newarr[i]*=left;
            left*=nums[i];
        }

        int right=1;
        for(int i=n-1;i>=0;i--)
        {
            newarr[i]*=right;
            right*=nums[i];
        }

        return newarr;
    }
}
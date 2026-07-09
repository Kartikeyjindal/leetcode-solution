class Solution 
{
    public int minRemoval(int[] nums, int k) 
    {
        Arrays.sort(nums);
        int n=nums.length;
        int maxl=0;

        int start=0;

        for(int i=0;i<n;i++)
        {
            if(nums[i] > (long)nums[start]*k)
            {
                start++;
            }
            maxl=Math.max(maxl,i-start+1);
        }
        return n-maxl;
    }
}
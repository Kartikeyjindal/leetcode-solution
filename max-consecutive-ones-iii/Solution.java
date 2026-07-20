class Solution 
{
    public int longestOnes(int[] nums, int k) 
    {
        int right=0;
        int left=0;
        int zero=0;
        int max=0;
        while(right<nums.length)
        {
            if(nums[right]==0)
            {
                zero++;
            }

            if(zero>k)
            {
                if(nums[left]==0)
                {
                    zero--;
                }
                left++;
            }
            if(zero<=k)
            {
                max=Math.max(max,right-left+1);
            }
            right++;
        }
        return max;
        
    }
}
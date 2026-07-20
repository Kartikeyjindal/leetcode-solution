class Solution 
{
    public int longestNiceSubarray(int[] nums) 
    {
        int n=nums.length;
        int left=0;
        int maxlength=1;
        int bit=0;
        for(int i=0;i<n;i++)
        {
            while((bit & nums[i])!=0)
            {
                bit=bit^nums[left];
                left++;
            }
            bit=bit|nums[i];
            maxlength=Math.max(maxlength,i-left+1);
        }
        return maxlength;
    }
}
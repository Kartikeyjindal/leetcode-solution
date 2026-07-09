class Solution 
{
    public int longestSubarray(int[] nums) 
    {
        int n = nums.length;
        int i = 0, j = 0;
        int sz = 0;
        int maxlength = 0;

        while (j < n) 
        {
            if (nums[j] == 0) 
            {
                sz++;
            }

            while (sz > 1) 
            {
                if (nums[i] == 0) 
                {
                    sz--;
                }
                i++;
            }
            maxlength = Math.max(maxlength, j - i);

            j++;
        }
        return maxlength;
    }
}

class Solution {
    public int longestMonotonicSubarray(int[] nums) 
    {
        if(nums.length == 0)
        {
            return 0;
        }

        int maxlength=1;
        int increase=1;
        int decrease=1;

        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>nums[i-1])
            {
                decrease++;
                increase=1;
            }
            else if(nums[i]<nums[i-1])
            {
                increase++;
                decrease=1;
            }
            else
            {
                increase=1;
                decrease=1;
            }
            maxlength=Math.max(maxlength , Math.max(increase,decrease));
        }
        return maxlength; 

    }
}
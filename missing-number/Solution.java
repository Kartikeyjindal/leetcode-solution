class Solution {
    public int missingNumber(int[] nums) 
    {
        int result=0;
        result=result^nums.length;
        for(int i=0;i<nums.length;i++)
        {
            result=result^nums[i]^i;
        }
        return result;
    }
}
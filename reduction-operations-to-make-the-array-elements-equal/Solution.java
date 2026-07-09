class Solution 
{
    public int reductionOperations(int[] nums) 
    {
        Arrays.sort(nums);
        int ops = 0, steps = 0;

        for(int i=1; i<nums.length; i++)
        {
            if(nums[i - 1] != nums[i])
            {
                steps++;
            }
            ops += steps;
        }
        return ops;
    }
}
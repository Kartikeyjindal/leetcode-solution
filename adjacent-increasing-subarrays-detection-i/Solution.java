class Solution 
{
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) 
    {
        int n = nums.size();
        for (int i = 0; i + 2 * k <= n; i++)
        {
            boolean first = inc(nums, i, i + k - 1);
            boolean second = inc(nums, i + k, i + 2 * k - 1);
            if (first && second)
            {
                return true;
            }
        }
        return false;
    }

    public boolean inc(List<Integer> nums, int start, int end)
    {
        for (int i = start + 1; i <= end; i++)
        {
            if (nums.get(i) <= nums.get(i - 1))
            {
                return false;
            }
        }
        return true;
    }
}

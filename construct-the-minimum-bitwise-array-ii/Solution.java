class Solution 
{
    public int[] minBitwiseArray(List<Integer> nums) 
    {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++)
        {
            ans[i] = solve(nums.get(i));
        }
        return ans;
    }

    public int solve(int i)
    {
        if ((i & 1) == 0)
        {
            return -1;
        }

        int dup = i;
        int zero = 0;

        for (int j = 0; j < 32; j++)
        {
            int x = (i & (1 << j));

            if (zero == 0 && iszero(x) && j > 0)
            {
                dup = dup ^ (1 << (j - 1));
                zero++;
                break;
            }
        }
        return dup;
    }

    public boolean iszero(int x)
    {
        return x == 0;
    }
}

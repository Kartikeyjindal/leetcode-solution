class Solution 
{
    public int minimumPairRemoval(int[] nums) 
    {
        int opr = 0;

        while (!issort(nums))
        {
            nums = sumcal(nums);
            opr++;
        }
        return opr;
    }

    public boolean issort(int[] nums)
    {
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] < nums[i - 1])
            {
                return false;
            }
        }
        return true;
    }

    public int[] sumcal(int[] nums)
    {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int a = 0;
        for (int i = 0; i < n - 1; i++)
        {
            int s = nums[i] + nums[i + 1];
            if (s < min)
            {
                min = s;
                a = i;
            }
        }
        int[] sum = new int[n - 1];
        int idx = 0;

        for (int i = 0; i < n; i++)
        {
            if (i == a)
            {
                sum[idx++] = min;
                i++;
            }
            else
            {
                sum[idx++] = nums[i];
            }
        }

        return sum;
    }
}

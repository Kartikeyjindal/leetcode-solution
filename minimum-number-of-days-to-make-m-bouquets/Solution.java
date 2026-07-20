class Solution 
{
    public int minDays(int[] bloomDay, int m, int k) 
    {
        if(bloomDay.length<(m*k))
        {
            return -1;
        }
        int left = bloomDay[0];
        int right = bloomDay[0];
        for (int i = 0; i < bloomDay.length; i++) 
        {
            right = Math.max(bloomDay[i], right);
            left = Math.min(bloomDay[i], left);
        }
        int ans = -1;
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(canfeasible(bloomDay, mid, k) >= m)
            {
                ans = mid;
                right = mid- 1;
            }
            else
            {
                left = mid + 1;
            }
        }
        return ans;
    }
    public int canfeasible(int[] nums, int day, int k) 
    {
        int bou = 0, count = 0;
        for (int i = 0; i < nums.length; i++) 
        {
            if (nums[i] <= day) 
            {
                count++;
                if (count == k) 
                {
                    bou++;
                    count = 0;
                }
            } 
            else 
            {
                count = 0;
            }
        }
        return bou;
    } 
}
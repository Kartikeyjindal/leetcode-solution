class Solution 
{
    public int maxIncreasingSubarrays(List<Integer> nums) 
    {
        int n = nums.size();
        if (n < 2) return 0;
        ArrayList<Integer> runs = new ArrayList<>();
        int curr = 1;
        for (int i = 1; i < n; i++)
        {
            if (nums.get(i) > nums.get(i - 1))
            {
                curr++;
            }
            else
            {
                runs.add(curr);
                curr = 1;
            }
        }
        runs.add(curr);

        int ans = 0;
        for (int len : runs)
        {
            ans = Math.max(ans, len / 2);
        }
        for (int i = 0; i + 1 < runs.size(); i++)
        {
            ans = Math.max(ans, Math.min(runs.get(i), runs.get(i + 1)));
        }

        return ans;
    }
}

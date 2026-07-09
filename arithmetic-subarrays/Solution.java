class Solution 
{
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) 
    {
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < l.length; i++)
        {
            ans.add(solve(nums, l[i], r[i]));
        }
        return ans;
    }

    public boolean solve(int[] nums, int l, int r)
    {
        int n = r - l + 1;
        if (n < 3)
        {
            return true;
        }

        int[] arr = new int[n];
        int a = 0;
        for (int i = l; i <= r; i++)
        {
            arr[a++] = nums[i];
        }

        Arrays.sort(arr);

        int diff = arr[1] - arr[0];
        for (int i = 2; i < n; i++)
        {
            if (arr[i] - arr[i - 1] != diff)
            {
                return false;
            }
        }
        return true;
    }
}

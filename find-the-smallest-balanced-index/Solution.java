class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int n = nums.length;

        long[] pref_sum = new long[n];
        long pro = 1;

        for (int i = 1; i < n; i++) {
            pref_sum[i] = pref_sum[i - 1] + nums[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            if (i + 1 < n) {
                pro = pro * nums[i + 1];
            }

            if (pref_sum[i] == pro) return i;

            if (pro > pref_sum[i]) return -1;
        }

        return -1;
    }
}
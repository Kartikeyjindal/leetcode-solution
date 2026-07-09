import java.util.*;
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        // First run: consider houses 0 to n-2
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n - 1; i++) {
            int take = nums[i - 1] + (i - 2 >= 0 ? dp[i - 2] : 0);
            int skip = dp[i - 1];
            dp[i] = Math.max(take, skip);
        }
        int result1 = dp[n - 1];

        // Second run: consider houses 1 to n-1
        dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0; // starting with house at index 1
        for (int i = 2; i <= n; i++) {
            int take = nums[i - 1] + dp[i - 2];
            int skip = dp[i - 1];
            dp[i] = Math.max(take, skip);
        }
        int result2 = dp[n];

        return Math.max(result1, result2);
    }
}

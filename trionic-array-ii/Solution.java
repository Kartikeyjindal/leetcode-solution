class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;

        long result = Long.MIN_VALUE;
        long preSum = nums[0];

        int l = 0;
        int p = 0;
        int q = 0;

        for (int r = 1; r < n; r++) {
            preSum += nums[r];
            if (nums[r - 1] == nums[r]) {
                l = r;
                preSum = nums[r];
            }
            else if (nums[r - 1] > nums[r]) { 
                if (r > 1 && nums[r - 2] < nums[r - 1]) {
                    p = r - 1; 

                    while (l < q) preSum -= nums[l++];
                    while (l < p - 1 && nums[l] < 0) preSum -= nums[l++];
                }
            }
            else {
                if (r > 1 && nums[r - 2] > nums[r - 1]) q = r - 1; 
                if (l < p && p < q) result = Math.max(result, preSum);
            }
        }

        return result;
    }
}
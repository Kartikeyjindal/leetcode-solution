class Solution 
{
    public int longestSubsequence(int[] nums) 
    {
        int[] sorelanuxi = nums;
        int ans = 0;
        for (int bit = 0; bit <= 30; bit++) {
            int mask = 1 << bit;
            ArrayList<Integer> lis = new ArrayList<>();

            for (int x : sorelanuxi) {
                if ((x & mask) == 0) continue;
                int pos = Collections.binarySearch(lis, x);
                if (pos < 0) pos = -(pos + 1);

                if (pos == lis.size()) {
                    lis.add(x);
                } else {
                    lis.set(pos, x);
                }
            }

            ans = Math.max(ans, lis.size());
        }

        return ans;
    }
}
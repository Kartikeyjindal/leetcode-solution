class Solution 
{
    int []dp = new int[10001];
    final int MOD = 1_000_000_007;

    public int countHousePlacements(int n) 
    {
        Arrays.fill(dp, -1); // Fill dp with -1 for memoization

        int oneside = solve(n+1, 0); // compute for one side
        long ans = (1L * oneside * oneside) % MOD; // square for both sides, mod to prevent overflow
        return (int) ans;
    }

    public int solve(int n, int i)
    {
        if(i == n) return 1; // valid configuration
        if(i > n) return 0;  // out of bounds
        if(dp[i] != -1) return dp[i];

        int take = solve(n, i + 2);  // place house at current, skip next
        int leave = solve(n, i + 1); // leave current plot empty

        return dp[i] = (take + leave) % MOD; // store and return result
    }
}

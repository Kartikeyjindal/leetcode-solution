class Solution 
{
    int []dp = new int[10001];
    final int MOD = 1_000_000_007;

    public int countHousePlacements(int n) 
    {
        Arrays.fill(dp, -1);

        int oneside = solve(n, 0);
        long ans = (1L * oneside * oneside) % MOD;
        return (int) ans;
    }

    public int solve(int n, int i)
    {
        if(i >= n) return 1;  
        if(dp[i] != -1) return dp[i];

        int take = solve(n, i + 2); 
        int leave = solve(n, i + 1);

        return dp[i] = (take + leave) % MOD;
    }
}

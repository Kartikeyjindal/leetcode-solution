class Solution 
{
    int []dp=new int[10001];
    final int MOD = 1_000_000_007;

    public int countHousePlacements(int n) 
    {
        Arrays.fill(dp, -1);

        int oneside = solve(n);
        long ans = (1L * oneside * oneside) % MOD;
        return (int) ans;
    }
    public int solve(int i)
    {
        if(i == 0) return 1;
        if(i == 1) return 2;

        if(dp[i] != -1) return dp[i];
        return dp[i] = (solve(i - 1) + solve(i - 2)) % MOD;
    }
}

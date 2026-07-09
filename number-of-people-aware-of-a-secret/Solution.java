class Solution 
{
    private static final int MOD = 1_000_000_007;
    Integer[][] memo;

    public int peopleAwareOfSecret(int n, int delay, int forget) 
    {
        memo = new Integer[n+1][2];
        int total=0;

        for(int days=n-forget+1; days<=n; days++)
        {
            if(days>0)
            {
                total = (total + solve(days, delay, forget, n)) % MOD;
            }
        }
        return total;
    }

    public int solve(int day, int delay, int forget, int n)
    {
        if(day == 1) return 1;

        if(memo[day][0] != null) return memo[day][0];

        long result = 0;

        for(int d = Math.max(1, day - forget + 1); d <= day - delay; d++)
        {
            result = (result + solve(d, delay, forget, n)) % MOD;
        }

        return memo[day][0] = (int)result;
    }
}

class Solution 
{
    int []dp=new int[10001];
    final int MOD = 1_000_000_007;
    public int countHousePlacements(int n) 
    {
        Arrays.fill(dp, -1);
        int ways=solve(n);
        long ans=(long)ways*ways;
        return (int)(ans%MOD);
    }

    public int solve(int n)
    {
        if(n==0)
        {
            return dp[n]=1;
        }
        if(n==1)
        {
            return dp[n]=2;
        }
        if(dp[n]!=-1)
        {
            return dp[n];
        }
        return dp[n]=(solve(n-1)+solve(n-2))%MOD;

    }
}
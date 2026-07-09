class Solution 
{
    public int[] sumAndMultiply(String s, int[][] queries) 
    {
        int m = s.length();
        int q = queries.length;
        long MOD = 1_000_000_007;
        long[] power10 = new long[m + 1];
        power10[0] = 1;
        for (int i = 1; i <= m; i++) 
        {
            power10[i] = (power10[i - 1] * 10) % MOD;
        }
        long[] pVal = new long[m + 1];
        int[] nzC = new int[m + 1];
        long[] pSum = new long[m + 1];
        for (int i = 0; i < m; i++) 
        {
            int c = s.charAt(i) - '0';
            pSum[i + 1] = pSum[i] + c;
            if (c != 0)
            {
                nzC[i + 1] = nzC[i] + 1;
                pVal[i + 1] = (pVal[i] * 10 + c) % MOD;
            } 
            else 
            {
                nzC[i + 1] = nzC[i];
                pVal[i + 1] = pVal[i];
            }
        }
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) 
        {
            int l = queries[i][0];
            int r = queries[i][1];
            long sum = pSum[r + 1] - pSum[l];
            int k = nzC[r + 1] - nzC[l];
            long x = (pVal[r + 1] - (pVal[l] * power10[k]) % MOD) % MOD;
            if (x < 0) {
                x += MOD;
            }
            ans[i] = (int) ((x * (sum % MOD)) % MOD);
        }
        return ans;
    }
}
class Solution 
{
    public int countSubstrings(String s) 
    {
        int n = s.length();
        Boolean[][] dp = new Boolean[n][n];
        
        for (Boolean[] row : dp) 
        {
            Arrays.fill(row, false);
        }

        int count = 0;

        for (int l = 1; l <= n; l++)
        {
            for (int i = 0; i <= n - l; i++)
            {
                int j = i + l - 1;

                if (i == j) 
                {
                    dp[i][j] = true;
                } 
                else if (i + 1 == j) 
                {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)); 
                } 
                else 
                {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                }

                if (dp[i][j]) 
                {
                    count++;
                }
            }
        }

        return count;
    }
}

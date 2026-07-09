class Solution 
{

    public int findMaxForm(String[] strs, int m, int n) 
    {
        int len = strs.length;
        int[][][] dp = new int[len][m + 1][n + 1];
        for (int i = 0; i < len; i++) 
        {
            for (int j = 0; j <= m; j++) 
            {
                for (int k = 0; k <= n; k++) 
                {
                    dp[i][j][k] = -1;
                }
            }
        }
        return solve(strs,0,m,n,dp);
    }

    public int solve(String []s,int i,int m,int n,int [][][]dp)
    {
        if(i==s.length)
        {
            return 0;
        }
        if(dp[i][m][n]!=-1)
        {
            return dp[i][m][n];
        }
        int zero=0,one=0;
        for(char c:s[i].toCharArray())
        {
            if(c=='0')
            {
                zero++;
            }
            else
            {
                one++;
            }
        }
        int nottake=solve(s,i+1,m,n,dp);
        int take=0;
        if(m>=zero&&n>=one)
        {
            take=1+solve(s,i+1,m-zero,n-one,dp);
        }
        dp[i][m][n]=Math.max(nottake,take);
        return dp[i][m][n];
    }
}
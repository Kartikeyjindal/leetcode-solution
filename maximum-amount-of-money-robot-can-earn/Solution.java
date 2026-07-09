class Solution 
{
    int n,m;
    int [][][]dp;
    public int maximumAmount(int[][] coins) 
    {
        n=coins.length;
        m=coins[0].length;

        dp=new int[n][m][3];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                for(int k=0;k<3;k++)
                {
                    dp[i][j][k]=Integer.MIN_VALUE;
                }
            }
        }
        return solve(coins,0,0,2);
    }

    public int solve(int[][] coins,int i,int j,int neu)
    {
        if(i==n-1 && j==m-1)
        {
            if(coins[i][j]<0 && neu>0)
            {
                return 0;
            }
            return coins[i][j];
        }
        if(i>=n || j>=m)
        {
            return Integer.MIN_VALUE;
        }
        if(dp[i][j][neu]!=Integer.MIN_VALUE)
        {
            return dp[i][j][neu];
        }
        int take=coins[i][j]+Math.max(solve(coins,i+1,j,neu),solve(coins,i,j+1,neu));
        int leave=Integer.MIN_VALUE;
        if(coins[i][j]<0 && neu>0)
        {
            int skipdown=solve(coins,i+1,j,neu-1);
            int skipside=solve(coins,i,j+1,neu-1);

            leave=Math.max(skipdown,skipside);
        }
        return dp[i][j][neu]=Math.max(take,leave);
    }
}
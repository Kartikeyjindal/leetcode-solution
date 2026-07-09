class Solution 
{
    int [][]dp=new int [101][101];
    public int uniquePaths(int m, int n) 
    {
        for(int []row:dp)
        {
            Arrays.fill(row,-1);
        }
        return solve(0,0,m,n);
    }

    public int solve(int i,int j,int m,int k)
    {
        if(i <0||i==m||j <0|| j==k)
        {
            return 0;
        }
        if(i==m-1||j==k-1)
        {
            return 1;
        }
        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }

        int right=solve(i+1,j,m,k);
        int down=solve(i,j+1,m,k);
        return dp[i][j]=right+down;
    }
}
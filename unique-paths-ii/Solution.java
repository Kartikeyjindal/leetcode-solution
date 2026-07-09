class Solution 
{
    int [][]dp=new int [101][101];
    public int uniquePathsWithObstacles(int[][] obstacleGrid) 
    {
        for(int []row:dp)
        {
            Arrays.fill(row,-1);
        }
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        return solve(obstacleGrid,0,0,m,n);
    }

    public int solve(int [][]obs,int i,int j,int m,int n)
    {
        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }
        if(i<0||i==m||j<0||j==n||obs[i][j]==1)
        {
            return dp[i][j]=0;
        }
        if(i==m-1 && j==n-1)
        {
            return dp[i][j]=1;
        }
        int right=solve(obs,i+1,j,m,n);
        int left=solve(obs,i,j+1,m,n);
        return dp[i][j]=right+left;
    }
}
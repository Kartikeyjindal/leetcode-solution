class Solution 
{
    Integer [][][]dp;
    int m,n;
    public int maxPathScore(int[][] grid, int k) 
    {
        m=grid.length;
        n=grid[0].length;
        dp=new Integer [m][n][k+1];
        int result= solve(0,0,0,0,grid,k);
        return result<0?-1:result;
    }

    public int solve(int i,int j,int c,int s,int [][]grid,int k)
    {
        if(i>=m || j>=n)
        {
            return Integer.MIN_VALUE;
        }
        int cost =(grid[i][j]==2)?1:grid[i][j];

        if(c+cost >k)
        {
            return Integer.MIN_VALUE;
        }
        if(dp[i][j][c]!= null)
        {
            return dp[i][j][c];
        }

        if(i==m-1 && j==n-1)
        {
            return dp[i][j][c]=grid[i][j];
        }


        int right=solve(i+1,j,c+cost,s+grid[i][j],grid,k);
        int down=solve(i,j+1,c+cost,s+grid[i][j],grid,k);

        int best= Math.max(right,down);
        if(best==Integer.MIN_VALUE)
        {
            dp[i][j][c]=Integer.MIN_VALUE;
        }
        return dp[i][j][c]=grid[i][j]+best;
    }
}
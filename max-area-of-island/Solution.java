class Solution 
{
    int ans=0;
    int curr=0;
    int m;
    int n;
    public int maxAreaOfIsland(int[][] grid) 
    {
        m=grid.length;
        n=grid[0].length;

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    int curr=solve(i,j,grid);
                    ans=Math.max(ans,curr);
                }
            }
        }
        return ans;
    }

    public int solve(int i,int j,int[][] grid)
    {
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]==0)
        {
            return 0;
        }

        grid[i][j]=0;
        return 1+solve(i+1,j,grid)+solve(i,j+1,grid)+solve(i-1,j,grid)+solve(i,j-1,grid);
    }
}
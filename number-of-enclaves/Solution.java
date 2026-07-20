class Solution 
{
    public int numEnclaves(int[][] grid) 
    {
        int n=grid.length;
        int m=grid[0].length;

        int [][]visited=new int [n][m];
        int count=0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if((i==0 || j==0 || i==n-1 || j==m-1) && grid[i][j]==1)
                {
                    dfs(grid,visited,i,j);
                }
            }
        }
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < m; j++) 
            {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;  
    }

    public void dfs(int[][]grid,int[][]visited,int row,int col)
    {
        int n=grid.length;
        int m=grid[0].length;
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        visited[row][col]=1;

        for(int i=0;i<4;i++)
        {
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];

            if(nrow>=0 && ncol>=0 && ncol<m && nrow<n && visited[nrow][ncol]==0 && grid[nrow][ncol]==1)
            {
                dfs(grid,visited,nrow,ncol);
            }
        }
    }
}
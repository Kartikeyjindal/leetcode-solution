class Solution 
{
    private static final int[][] dirs = { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };
    int m,n;
    int target;
    public int lenOfVDiagonal(int[][] grid) 
    {
        n=grid.length;
        m=grid[0].length;
        target=2;
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    for(int d=0;d<4;d++)
                    {
                        ans=Math.max(ans,solve(i,j,d,1,2,grid)+1);
                    }
                }
            }
        }
        return ans;
    }
    public int solve(int i,int j,int direction,int turn,int search,int [][]grid)
    {
        int ni=i+dirs[direction][0];
        int nj=j+dirs[direction][1];
        if(ni<0||ni>=n||nj<0||nj>=m||grid[ni][nj]!=search)
        {
            return 0;
        }
        int ans =solve(ni,nj,direction,turn,2-search,grid);
        if(turn>0)
        {
            ans=Math.max(ans,solve(ni,nj,(direction+1)%4,turn-1,2-search,grid));
        }
        return ans+1;
    }
}
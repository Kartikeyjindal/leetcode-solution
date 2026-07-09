class Solution 
{
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) 
    {
        int n=grid.length;
        int m=grid[0].length;
        int [][]ans=new int[n][m];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                ans[i][j]=grid[i][j];
            }
        }

        int start=x;int end=x+k-1;
        while(start<end)
        {
            for(int i=y;i<y+k;i++)
            {
                ans[start][i]=grid[end][i];
                ans[end][i]=grid[start][i];
            }
            start++;
            end--;
        }
        return ans;

    }
}
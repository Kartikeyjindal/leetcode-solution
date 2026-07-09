class Solution 
{
    public int countSubmatrices(int[][] grid, int k) 
    {
        int n=grid.length;
        int m=grid[0].length;

        int [][]prefix=new int[n][m];
        prefix[0][0]=grid[0][0];

        for(int i=1;i<n;i++)
        {
            prefix[i][0]=prefix[i-1][0]+grid[i][0];
        }
        for(int i=1;i<m;i++)
        {
            prefix[0][i]=prefix[0][i-1]+grid[0][i];
        }

        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                prefix[i][j]=prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1]+grid[i][j];
            }
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(prefix[i][j]<=k)
                {
                    ans++;
                }
            }
        }
        return ans;
    }
}
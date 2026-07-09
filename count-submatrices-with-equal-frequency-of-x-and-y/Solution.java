class Solution 
{
    public int numberOfSubmatrices(char[][] grid) 
    {
        int nx=0;
        int ny=0;
        int n=grid.length;
        int m=grid[0].length;
        int[][]g=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='X')
                {
                    g[i][j]=1;
                    nx++;
                }
                else if(grid[i][j]=='Y')
                {
                    g[i][j]=-1;
                    ny++;
                }
                else
                {
                    g[i][j]=0;
                }
            }
        }
        if(nx==0 || ny==0)
        {
            return 0;
        }
        int [][]prefix=new int[n][m];
        prefix[0][0]=g[0][0];

        for(int i=1;i<n;i++)
        {
            prefix[i][0]=prefix[i-1][0]+g[i][0];
        }
        for(int i=1;i<m;i++)
        {
            prefix[0][i]=prefix[0][i-1]+g[0][i];
        }

        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                prefix[i][j]=prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1]+g[i][j];
            }
        }
        int ans=0;
        int idx=n;
        int sub=0;
        for(int j=0; j<m; j++)
        {
            if(prefix[0][j]!=0)
            {
                idx = j;
                break;
            }
            else sub++;
        }
        for(int i=1; i<n; i++)
        {
            for(int j=0; j<idx; j++)
            {
                if(prefix[i][j]!=0)
                {
                    idx = j;
                    break;
                }
                else sub++;
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(prefix[i][j]==0)
                {
                    ans++;
                }
            }
        }
        return ans-sub;
    }
}
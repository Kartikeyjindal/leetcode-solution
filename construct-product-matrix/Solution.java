class Solution 
{
    public int[][] constructProductMatrix(int[][] grid) 
    {
        long products=1;
        long productp=1;
        int n=grid.length;
        int m=grid[0].length;
        int [][]p=new int[n][m];
        int mod=12345;
        long [][]suffix=new long[n][m];
        long [][]prefix=new long[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                prefix[i][j]=productp%mod;
                productp=(productp*grid[i][j])%mod;
            }
        }
        for(int i=n-1;i>=0;i--)
        {
            for(int j=m-1;j>=0;j--)
            {
                suffix[i][j]=products%mod;
                products=(products*grid[i][j])%mod;
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                p[i][j]=(int)(suffix[i][j]*prefix[i][j])%mod;
            }
        }

        
        return p; 
    }
}
class Solution 
{
    long [][]dpmax;
    long [][]dpmin;
    int n;int m;
    long mod = 1000000007;
    public int maxProductPath(int[][] grid) 
    {
        n=grid.length;
        m=grid[0].length;
        dpmax=new long[n][m];
        dpmin=new long[n][m];
        dpmax[0][0]=grid[0][0];
        dpmin[0][0]=grid[0][0];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i==0 && j==0)
                {
                    continue;
                }
                int val=grid[i][j];
            long lmin=Long.MAX_VALUE;
            long lmax=Long.MIN_VALUE;
            if(i>0)
            {
                long a=dpmax[i-1][j]*val;
                long b=dpmin[i-1][j]*val;

                lmax=Math.max(lmax,Math.max(a,b));
                lmin=Math.min(lmin,Math.min(a,b));
            }
            if(j>0)
            {
                long a=dpmax[i][j-1]*val;
                long b=dpmin[i][j-1]*val;

                lmax=Math.max(lmax,Math.max(a,b));
                lmin=Math.min(lmin,Math.min(a,b));
            }
            dpmax[i][j]=lmax;
            dpmin[i][j]=lmin;
            }
        }
        long ans=dpmax[n-1][m-1];
        if(ans<0)
        {
            return -1;
        }
        return (int)(ans%mod);
    }
    
}
class Solution 
{
    public boolean canPartitionGrid(int[][] grid) 
    {
        int m=grid.length;
        int n=grid[0].length;

        long []prefixr=new long[m];
        long []prefixc=new long[n];

        long sum=0;
        for(int i=0;i<m;i++)
        {
            sum=0;
            for(int j=0;j<n;j++)
            {
                sum+=grid[i][j];
            }
            prefixr[i]=sum;
        }

        for(int i=0;i<n;i++)
        {
            sum=0;
            for(int j=0;j<m;j++)
            {
                sum+=grid[j][i];
            }
            prefixc[i]=sum;
        }

        for(int i=1;i<m;i++)
        {
            prefixr[i]=prefixr[i]+prefixr[i-1];
        }
        for(int i=1;i<n;i++)
        {
            prefixc[i]=prefixc[i]+prefixc[i-1];
        }

        for(int i=0;i<m-1;i++)
        {
            if(prefixr[i]==prefixr[m-1]-prefixr[i])
            {
                return true;
            }
        }
        for(int i=0;i<n-1;i++)
        {
            if(prefixc[i]==prefixc[n-1]-prefixc[i])
            {
                return true;
            }
        }
        return false;

    }
}
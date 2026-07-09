class Solution 
{
    public int largestOverlap(int[][] a, int[][] b) 
    {
        int ans=0;
        int n=a.length;

        for(int i=-n+1;i<n;i++)
        {
            for(int j=-n+1;j<n;j++)
            {
                int curr=solve(a,b,i,j);
                ans=Math.max(ans,curr);
            }
        }
        return ans;
    }

    public int solve(int[][] a,int[][] b,int rowbuf,int colbuf)
    {
        int n=a.length;
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int row=i+rowbuf;
                int col=j+colbuf;

                if(row<0 || row>=n || col>=n || col<0)
                {
                    continue;
                }
                if(a[i][j]==1 && b[row][col]==1)
                {
                    count++;
                }
            }
        }
        return count;
    }
}
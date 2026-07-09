class Solution 
{
    public int n,m;
    int [][]dp=new int [301][301];
    public int countSquares(int[][] matrix) 
    {
        m=matrix.length;
        n=matrix[0].length;
        for(int []row:dp)
        {
            Arrays.fill(row,-1);
        }
        int result=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                result+=solve(i,j,matrix);
            }
        }
        return result;
    }
    public int solve(int i,int j,int [][]matrix)
    {
        if(i>=m||j>=n)
        {
            return 0;
        }
        if(matrix[i][j]!=1)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int right=solve(i+1,j,matrix);
        int down=solve(i,j+1,matrix);
        int disg=solve(i+1,j+1,matrix);

        return dp[i][j]=1+Math.min(right,Math.min(down,disg));
    }
}
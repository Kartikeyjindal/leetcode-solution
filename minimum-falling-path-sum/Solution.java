class Solution 
{
    int [][]dp;
    public int minFallingPathSum(int[][] matrix) 
    {
        int n=matrix.length;
        dp=new int[n][n];
        for(int []a:dp)
        {
            Arrays.fill(a,Integer.MIN_VALUE);
        }
        int row=0;
        int result=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            result=Math.min(result,solve(matrix,row,i));
        }
        return result;
    }

    public int solve(int [][]matrix,int row,int col)
    {
        int n=matrix.length;

        if(col>=n || col<0)
        {
            return Integer.MAX_VALUE;
        }

        if(row == n-1)
        {
            return matrix[row][col];
        }

        if(dp[row][col]!= Integer.MIN_VALUE)
        {
            return dp[row][col];
        }

        int sum=matrix[row][col];

        int left=solve(matrix,row+1,col-1);
        int down=solve(matrix,row+1,col);
        int right=solve(matrix,row+1,col+1);

        return dp[row][col]=sum+Math.min(left,Math.min(down,right));
    }
}
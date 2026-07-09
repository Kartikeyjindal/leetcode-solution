class Solution 
{
    public long maxMatrixSum(int[][] matrix) 
    {
        int n = matrix.length;
        int m = matrix[0].length;

        int smallest = Integer.MAX_VALUE;
        long sum = 0;
        int noofnegative = 0;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (matrix[i][j] < 0)
                {
                    noofnegative++;
                }
                smallest = Math.min(smallest, Math.abs(matrix[i][j]));
                sum += Math.abs(matrix[i][j]);
            }
        }

        if (noofnegative % 2 == 0)
        {
            return sum;
        }
        return sum - 2L * smallest;
    }
}

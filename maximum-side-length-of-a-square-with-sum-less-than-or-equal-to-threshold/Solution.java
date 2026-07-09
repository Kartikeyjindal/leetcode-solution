class Solution 
{
    int[][] prefsum;

    public int maxSideLength(int[][] mat, int threshold) 
    {
        int n = mat.length;
        int m = mat[0].length;
        int sidelength = 0;

        prefsum = psum(mat);

        for (int side = Math.min(n, m); side >= 1; side--)
        {
            for (int i = 0; i + side <= n; i++)
            {
                for (int j = 0; j + side <= m; j++)
                {
                    if (sqsum(i, j, side) <= threshold)
                    {
                        return side;
                    }
                }
            }
        }
        return 0;
    }
    public int sqsum(int i, int j, int k)
    {
        int r1 = i, c1 = j;
        int r2 = i + k - 1, c2 = j + k - 1;

        int sum = prefsum[r2][c2];
        if (r1 > 0) sum -= prefsum[r1 - 1][c2];
        if (c1 > 0) sum -= prefsum[r2][c1 - 1];
        if (r1 > 0 && c1 > 0) sum += prefsum[r1 - 1][c1 - 1];

        return sum;
    }
    public int[][] psum(int[][] mat)
    {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ps = new int[n][m];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                ps[i][j] = mat[i][j];
                if (i > 0) ps[i][j] += ps[i - 1][j];
                if (j > 0) ps[i][j] += ps[i][j - 1];
                if (i > 0 && j > 0) ps[i][j] -= ps[i - 1][j - 1];
            }
        }
        return ps;
    }
}

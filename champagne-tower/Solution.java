class Solution 
{
    double [][]dp = new double[101][101];

    public double champagneTower(int poured, int query_row, int query_glass) 
    {
        for(double[] row : dp)
            Arrays.fill(row, -1.0);

        return Math.min(1.0, solve(poured, query_row, query_glass));
    }

    public double solve(int p, int r, int g)
    {
        // invalid cases
        if(g < 0 || g > r)
            return 0.0;

        // top glass
        if(r == 0 && g == 0)
            return p;

        if(dp[r][g] != -1.0)
            return dp[r][g];

        double leftparent = solve(p, r-1, g-1);
        double rightparent = solve(p, r-1, g);

        double leftflow = Math.max(0.0, (leftparent - 1) / 2.0);
        double rightflow = Math.max(0.0, (rightparent - 1) / 2.0);

        return dp[r][g] = leftflow + rightflow;
    }
}

class Solution {
    int[][][][] dp;
    int n, m;

    public int cherryPickup(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        dp = new int[n][m][n][m];
        
        for (int[][][] a : dp) {
            for (int[][] b : a) {
                for (int[] c : b) {
                    Arrays.fill(c, Integer.MIN_VALUE);
                }
            }
        }
        return Math.max(0, solve(0, 0, 0, 0, grid));
    }

    private int solve(int r1, int c1, int r2, int c2, int[][] grid) {
        if (r1 >= n || c1 >= m || r2 >= n || c2 >= m 
            || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }
        if (r1 == n - 1 && c1 == m - 1) {
            return grid[r1][c1];
        }

        if (dp[r1][c1][r2][c2] != Integer.MIN_VALUE) {
            return dp[r1][c1][r2][c2];
        }

        int cherries = 0;
        if (r1 == r2 && c1 == c2) {
            cherries += grid[r1][c1];
        } else {
            cherries += grid[r1][c1] + grid[r2][c2];
        }

        int best = Math.max(
            Math.max(solve(r1, c1 + 1, r2, c2 + 1, grid), solve(r1 + 1, c1, r2 + 1, c2, grid)),
            Math.max(solve(r1 + 1, c1, r2, c2 + 1, grid), solve(r1, c1 + 1, r2 + 1, c2, grid))
        );

        cherries += best;
        dp[r1][c1][r2][c2] = cherries;
        return cherries;
    }
}

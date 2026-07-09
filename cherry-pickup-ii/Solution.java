class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];
        for (int[][] arr2D : dp) {
            for (int[] arr1D : arr2D) {
                Arrays.fill(arr1D, -1);
            }
        }

        return solution(0, 0, m - 1, n, m, grid, dp);
    }

    public int solution(int r1, int c1, int c2, int n, int m, int[][] grid, int[][][] dp) {
        if (c1 < 0 || c1 >= m || c2 < 0 || c2 >= m) {
            return Integer.MIN_VALUE;
        }

        if (r1 == n - 1) {
            if (c1 == c2) {
                return grid[r1][c1];
            } else {
                return grid[r1][c1] + grid[r1][c2];
            }
        }
        if (dp[r1][c1][c2] != -1) {
            return dp[r1][c1][c2];
        }

        int cherries = (c1 == c2) ? grid[r1][c1] : grid[r1][c1] + grid[r1][c2];
        int maxNext = Integer.MIN_VALUE;

        for (int nc1 = c1 - 1; nc1 <= c1 + 1; nc1++) {
            for (int nc2 = c2 - 1; nc2 <= c2 + 1; nc2++) {
                maxNext = Math.max(maxNext, solution(r1 + 1, nc1, nc2, n, m, grid, dp));
            }
        }

        return dp[r1][c1][c2] = cherries + maxNext;
    }
}

class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[][] dp = new int[piles.size() + 1][k + 1];
        
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return solution(piles, dp, 0, k);
    }

    public int solution(List<List<Integer>> piles, int[][] dp, int i, int remaining) {
        if (remaining == 0 || i == piles.size()) {
            return 0;
        }

        if (dp[i][remaining] != -1) {
            return dp[i][remaining];
        }

        int ans = solution(piles, dp, i + 1, remaining);

        int currSum = 0;
        for (int j = 0; j < Math.min(piles.get(i).size(), remaining); j++) {
            currSum += piles.get(i).get(j);
            ans = Math.max(ans, currSum + solution(piles, dp, i + 1, remaining - j - 1));
        }

        return dp[i][remaining] = ans;
    }
}

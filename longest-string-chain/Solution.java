class Solution {
    public int[][] dp = new int[1001][1001];

    public boolean predecessor(String pre, String cur) {
        int m = pre.length();
        int n = cur.length();
        if (m >= n || n - m != 1) {
            return false;
        }
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (pre.charAt(i) == cur.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == m;
    }

    public int longestStrChain(String[] words) {
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        return lis(words, -1, 0);
    }

    public int lis(String[] words, int prev, int curr) {
        if (curr == words.length) {
            return 0;
        }

        if (prev != -1 && dp[prev + 1][curr] != -1) {
            return dp[prev + 1][curr];
        }

        int take = 0;
        if (prev == -1 || predecessor(words[prev], words[curr])) {
            take = 1 + lis(words, curr, curr + 1);
        }

        int skip = lis(words, prev, curr + 1);
        int result = Math.max(take, skip);

        if (prev != -1) {
            dp[prev + 1][curr] = result;
        }

        return result;
    }
}

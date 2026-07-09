class Solution {
    Map<Integer, Integer> mp = new HashMap<>();
    int[][] t = new int[2001][2001];

    public boolean canCross(int[] stones) {
        if (stones[1] != 1)
            return false;

        for (int i = 0; i < stones.length; i++) {
            mp.put(stones[i], i);
        }

        for (int i = 0; i < 2000; i++) {
            Arrays.fill(t[i], -1);
        }

        return stone(stones, 0, 0);
    }

    public boolean stone(int[] stones, int curr, int prev) {
        if (curr == stones.length - 1) {
            return true;
        }

        if (t[curr][prev] != -1) {
            return t[curr][prev] == 1;
        }

        boolean result = false;

        for (int next = prev - 1; next <= prev + 1; next++) {
            if (next > 0) {
                int nextstone = stones[curr] + next;
                if (mp.containsKey(nextstone)) {
                    result = result || stone(stones, mp.get(nextstone), next);
                }
            }
        }

        t[curr][prev] = (result ? 1 : 0);
        return result;
    }
}

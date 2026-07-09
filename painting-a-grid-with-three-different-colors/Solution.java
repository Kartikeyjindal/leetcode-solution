class Solution 
{
    List<String> state = new ArrayList<>();
    int[][] t;
    int MOD = 1_000_000_007;

    public int colorTheGrid(int m, int n) 
    {
        state.clear();
        generate("", m, '#');

        t = new int[n][state.size()];
        for (int[] row : t)
        {
            Arrays.fill(row, -1);
        }

        int result = 0;
        for (int i = 0; i < state.size(); i++)
        {
            result = (result + solve(n - 1, i, m)) % MOD;
        }

        return result;
    }
    public void generate(String current, int m, char prev)
    {
        if (m == 0)
        {
            state.add(current);
            return;
        }

        for (char ch : new char[]{'R', 'G', 'B'})
        {
            if (ch == prev) continue;
            generate(current + ch, m - 1, ch);
        }
    }

    public int solve(int col, int prevIdx, int m)
    {
        if (col == 0)
        {
            return 1;
        }

        if (t[col][prevIdx] != -1)
        {
            return t[col][prevIdx];
        }

        String prev = state.get(prevIdx);
        int result = 0;

        for (int i = 0; i < state.size(); i++)
        {
            String curr = state.get(i);
            boolean conflict = false;

            for (int k = 0; k < m; k++)
            {
                if (curr.charAt(k) == prev.charAt(k))
                {
                    conflict = true;
                    break;
                }
            }
            if (!conflict)
            {
                result = (result + solve(col - 1, i, m)) % MOD;
            }
        }

        return t[col][prevIdx] = result;
    }
}

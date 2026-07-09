class Solution 
{
    int M = 1_000_000_007;
    int[][] t;

    // 12 possible valid row patterns
    String[] states = {
        "RYG", "RGY", "RYR", "RGR",
        "YRG", "YGR", "YGY", "YRY",
        "GRY", "GYR", "GRG", "GYG"
    };

    public int numOfWays(int n) 
    {
        t = new int[n][12];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < 12; j++)
            {
                t[i][j] = -1;
            }
        }

        int result = 0;
        for (int i = 0; i < 12; i++)
        {
            result = (result + solve(n - 1, i)) % M;
        }
        return result;
    }

    public int solve(int n, int prev)
    {
        if (n == 0)
        {
            return 1;
        }
        if (t[n][prev] != -1)
        {
            return t[n][prev];
        }

        String prevs = states[prev];
        int result = 0;

        for (int i = 0; i < 12; i++)
        {
            String curr = states[i];
            boolean flag = false;

            for (int k = 0; k < 3; k++)
            {
                if (curr.charAt(k) == prevs.charAt(k))
                {
                    flag = true;
                    break;
                }
            }

            if (!flag)
            {
                result = (result + solve(n - 1, i)) % M;
            }
        }
        return t[n][prev] = result;
    }
}

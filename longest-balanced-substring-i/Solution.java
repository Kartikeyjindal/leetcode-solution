class Solution 
{
    public int longestBalanced(String s) 
    {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++)
        {
            ArrayList<Integer> freq = new ArrayList<>();
            for (int k = 0; k < 26; k++)
            {
                freq.add(0);
            }

            for (int j = i; j < n; j++)
            {
                int idx = s.charAt(j) - 'a';
                freq.set(idx, freq.get(idx) + 1);

                if (check(freq))
                {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }

    public boolean check(ArrayList<Integer> freq)
    {
        int count = 0;

        for (int i = 0; i < 26; i++)
        {
            if (freq.get(i) == 0) continue;

            if (count == 0)
                count = freq.get(i);
            else if (count != freq.get(i))
                return false;
        }
        return true;
    }
}

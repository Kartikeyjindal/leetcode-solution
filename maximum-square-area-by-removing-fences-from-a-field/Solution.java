class Solution 
{
    public int maximizeSquareArea(int m, int n, int[] hf, int[] vf) 
    {
        List<Integer> hlist = new ArrayList<>();
        List<Integer> vlist = new ArrayList<>();

        hlist.add(1);
        hlist.add(m);
        for (int h : hf)
        {
            hlist.add(h);
        }

        vlist.add(1);
        vlist.add(n);
        for (int v : vf)
        {
            vlist.add(v);
        }

        Set<Integer> set = new HashSet<>();
        long ans = 0;

        for (int i = 0; i < hlist.size(); i++)
        {
            for (int j = i + 1; j < hlist.size(); j++)
            {
                set.add(Math.abs(hlist.get(j) - hlist.get(i)));
            }
        }

        for (int i = 0; i < vlist.size(); i++)
        {
            for (int j = i + 1; j < vlist.size(); j++)
            {
                int val = Math.abs(vlist.get(j) - vlist.get(i));
                if (set.contains(val))
                {
                    ans = Math.max(ans, val);
                }
            }
        }

        if (ans == 0)
        {
            return -1;
        }

        long MOD = 1_000_000_007;
        return (int)((ans * ans) % MOD);
    }
}

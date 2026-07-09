class Solution 
{
    public boolean predecessor(String pre, String cur) 
    {
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

    public int longestStrChain(String[] words) 
    {
        int n=words.length;
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        int []dp=new int[n];
        Arrays.fill(dp,1);

        int maxl=1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(predecessor(words[j],words[i]))
                {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    maxl=Math.max(maxl,dp[i]);
                }
            }
        }
        return maxl;
    }
}

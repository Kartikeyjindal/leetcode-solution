class Solution 
{
    public String longestPalindrome(String s) 
    {
        int n=s.length();
        boolean [][]dp=new boolean[n+1][n+1];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],false);
        }
        int start=0;
        int maxlen=0;
        for(int l=1;l<=n;l++)
        {
            for(int i=0;i+l-1<n;i++)
            {
                int j=i+l-1;
                if(i==j)
                {
                    dp[i][j]=true;
                    maxlen=Math.max(maxlen,l);
                    start=i;
                }
                else if(i+1==j && s.charAt(i)==s.charAt(j))
                {
                    dp[i][j]=true;
                    maxlen=Math.max(maxlen,l);
                    start=i;
                }

                else
                {
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1])
                    {
                        dp[i][j]=true;
                        maxlen=Math.max(maxlen,l);
                        start=i;
                    }
                }
            }
        }
        return s.substring(start,start+maxlen);
    }
}
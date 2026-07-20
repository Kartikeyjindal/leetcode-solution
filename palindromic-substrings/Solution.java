class Solution 
{
    public int countSubstrings(String s) 
    {
        int n=s.length();
        boolean [][]dp=new boolean[n+1][n+1];
        int count=0;

        for(int l=1;l<=n;l++)
        {
            for(int i=0;i+l-1<n;i++)
            {
                int j=i+l-1;
                if(i==j)
                {
                    if(s.charAt(i)==s.charAt(j))
                    {
                        dp[i][j]=true;
                    }
                    else
                    {
                        dp[i][j]=false;
                    }
                }
                else if(i+1==j)
                {
                    if(s.charAt(i)==s.charAt(j))
                    {
                        dp[i][j]=true;
                    }
                    else
                    {
                        dp[i][j]=false;
                    }
                }
                else
                {
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1])
                    {
                        dp[i][j]=true;
                    }
                    else
                    {
                        dp[i][j]=false;
                    }
                }
                if(dp[i][j])
                {
                    count++;
                }
            }
        }
        return count;
    }
}
class Solution 
{
    public Boolean [][]dp=new Boolean[1001][1001];
    public String longestPalindrome(String s) 
    {
        for(Boolean []row:dp)
        {
            Arrays.fill(row,false);
        }
        int n=s.length();
        int maxlength=0;
        int strt=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                if(solve(s,i,j))
                {
                    if(j-i+1 > maxlength)
                    {
                        maxlength=j-i+1;
                        strt=i;
                    }
                }
            }
        }
        String result=s.substring(strt,strt+maxlength);
        return result;
    }
    public boolean solve(String s,int i,int j)
    {
        if(i>=j)
        {
            return true;
        }
        if(dp[i][j])
        {
            return dp[i][j];
        }
        if(s.charAt(i) == s.charAt(j))
        {
            return dp[i][j]=solve(s,i+1,j-1);
        }
        return false;
    }
}
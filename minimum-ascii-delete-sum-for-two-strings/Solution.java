class Solution 
{
    int [][]dp;
    int n;
    int m;
    public int minimumDeleteSum(String s1, String s2) 
    {
        n=s1.length();
        m=s2.length();
        dp=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                dp[i][j]=-1;
            }
        }
        return solve(s1,s2,0,0);
    }
    public int solve(String s1,String s2,int i,int j)
    {
        if(i>=n && j>=m)
        {
            return 0;
        }
        if(i>=n)
        {
            return s2.charAt(j)+solve(s1,s2,i,j+1);
        }
        if(j>=m)
        {
            return s1.charAt(i)+solve(s1,s2,i+1,j);
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j))
        {
            return solve(s1,s2,i+1,j+1);
        }
        int deli=s1.charAt(i)+solve(s1,s2,i+1,j);
        int delj=s2.charAt(j)+solve(s1,s2,i,j+1);

        return dp[i][j]=Math.min(deli,delj);
    }
}
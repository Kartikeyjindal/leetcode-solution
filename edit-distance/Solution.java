class Solution 
{
    public int [][] dp=new int[501][501];
    public int minDistance(String word1, String word2) 
    {
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return solve(word1,word2,0,0);
    }

    public int solve(String s1,String s2,int i , int j)
    {
        int m=s1.length();
        int n=s2.length();
        if(i==m)
        {
            return n-j;
        }
        if(j==n)
        {
            return m-i;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j))
        {
            return dp[i][j]=solve(s1,s2,i+1,j+1);
        }
        else
        {
            int insert=1+solve(s1,s2,i,j+1);
            int delete=1+solve(s1,s2,i+1,j);
            int replace=1+solve(s1,s2,i+1,j+1);
            return dp[i][j]=Math.min(Math.min(insert,delete),replace);
        }
    }
}
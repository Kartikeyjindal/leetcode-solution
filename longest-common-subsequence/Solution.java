class Solution 
{
    public int [][]temp=new int[1001][1001];
    public int longestCommonSubsequence(String text1, String text2) 
    {
        for (int[] r : temp)
            Arrays.fill(r, -1);
       return solve(text1,text2,0,0);
    }

    public int solve(String s1,String s2,int i,int j)
    {
        if(temp[i][j]!=-1)
        {
            return temp[i][j];
        }
        if(i>= s1.length() || j>=s2.length())
        {
            return 0;
        }
        if(s1.charAt(i)== s2.charAt(j))
        {
            return temp[i][j]=1+solve(s1,s2,i+1,j+1);
        }
        else
        {
            return temp[i][j]=Math.max(solve(s1,s2,i+1,j),solve(s1,s2,i,j+1));
        }
    }
}
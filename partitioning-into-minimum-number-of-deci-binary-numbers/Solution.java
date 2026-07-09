class Solution
{
    public int minPartitions(String s) 
    {
        int ans=0;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            ans=Math.max(ans,s.charAt(i)-'0');
        }
        return ans;
    }
}
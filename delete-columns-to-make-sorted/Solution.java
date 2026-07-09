class Solution 
{
    public int minDeletionSize(String[] strs) 
    {
        int len=strs.length;
        int wordlength=strs[0].length();
        int ans=0;
        for(int i=0;i<wordlength;i++)
        {
            char prev=strs[0].charAt(i);
            for(int j=1;j<len;j++)
            {
                char newletter=strs[j].charAt(i);
                if(prev>newletter)
                {
                    ans++;
                    break;
                }
                prev=newletter;
            }
        }
        return ans;
    }
}
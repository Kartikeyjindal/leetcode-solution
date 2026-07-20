class Solution 
{
    public int minimumRecolors(String blocks, int k) 
    {
        int ans=0;
        int black=0;
        int weight=0;

        for(int i=0;i<k;i++)
        {
            if(blocks.charAt(i) == 'W')
            {
                weight++;
            }
        }
        ans=weight;
        
        for(int i=k;i<blocks.length();i++)
        {
            if(blocks.charAt(i) == 'W')
            {
                weight++;
            }
            if(blocks.charAt(i-k) == 'W')
            {
                weight--;
            }
            ans=Math.min(ans,weight);
        }
        return ans;
    }
}
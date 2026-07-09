class Solution 
{
    public int binaryGap(int n) 
    {
        int dis=0;
        int maxdis=0;
        while(n>0)
        {
            int letter=n&1;
            n=n>>1;
            if(letter==1 && dis>0)
            {
                maxdis=Math.max(maxdis,dis);
                dis=0;
            }
            if(letter==1 && dis==0)
            {
                dis++;
            }
            if(letter==0 && dis>0)
            {
                dis++;
            }
        }
        return maxdis;
    }
}
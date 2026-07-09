class Solution 
{
    public int[] successfulPairs(int[] spells, int[] potions, long success) 
    {
        int ns=spells.length;
        int np=potions.length;
        Arrays.sort(potions);
        int []ans=new int[ns];
        for(int i=0;i<ns;i++)
        {
            int spell=spells[i];
            int left=0;
            int right=np-1;
            while(left<=right)
            {
                int mid=left+(right-left)/2;
                long product=spell*(long)potions[mid];
                if(product>=success)
                {
                    right=mid-1;
                }
                else
                {
                    left=mid+1;
                }
            }
            ans[i]=np-left;
        }
        return ans ;
    }
}
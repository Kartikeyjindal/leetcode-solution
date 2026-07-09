class Solution 
{
    public int minimumCost(int[] cost) 
    {
        Arrays.sort(cost);
        int n=cost.length;
        int ans=0;
        int k=0;
        for(int i=n-1;i>=0;i--)
        {
            if(k<2)
            {
                ans+=cost[i];
                k++;
            }
            else if(k==2)
            {
                k=0;
            }
        }
        return ans;
    }
}
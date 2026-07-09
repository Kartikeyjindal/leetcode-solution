class Solution 
{
    public int maxIceCream(int[] costs, int coins) 
    {
        int n=costs.length;
        Arrays.sort(costs);
        int currcost=0;
        int ans=0;

        if(coins<costs[0])
        {
            return 0;
        }

        for(int i=0;i<n;i++)
        {
            if(currcost+costs[i]<=coins)
            {
                currcost+=costs[i];
                ans++;
            }
            else
            {
                break;
            }
        }
        return ans;
    }
}
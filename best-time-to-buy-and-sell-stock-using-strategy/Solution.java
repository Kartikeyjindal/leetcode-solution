class Solution 
{
    public long maxProfit(int[] prices, int[] strategy, int k) 
    {
        int n=prices.length;

        long baseprofit=0;
        for(int i=0;i<n;i++)
        {
            baseprofit+=prices[i]*strategy[i];
        }

        long[]prefixprice=new long[n+1];
        long[]prefixstrategy=new long[n+1];

        for(int i=0;i<n;i++)
        {
            prefixprice[i+1]=prefixprice[i]+prices[i];
            prefixstrategy[i+1]=prefixstrategy[i]+strategy[i]*prices[i];
        }
        long maxp=0;
        int mid=k/2;

        for(int i=0;i+k<=n;i++)
        {
            long old=prefixstrategy[i+k]-prefixstrategy[i];
            long newp=prefixprice[i+k]-prefixprice[i+mid];
            long gain=newp-old;
            maxp=Math.max(maxp,gain);
        }
        return baseprofit+maxp;
    }
}
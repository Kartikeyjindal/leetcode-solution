class Solution 
{
    public int bestClosingTime(String customers) 
    {
        int profit=0,maxprofit=0,besttime=0;

        for(int i=0;i<customers.length();i++)
        {
            if(customers.charAt(i)=='Y')
            {
                profit+=1;
            }
            else
            {
                profit+=-1;
            }
            if(profit>maxprofit)
            {
                maxprofit=profit;
                besttime=i+1;
            }
        }
        return besttime;
    }
}
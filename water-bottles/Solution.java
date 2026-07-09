class Solution 
{
    public int numWaterBottles(int numBottles, int numExchange) 
    {
        int drinking =0;
        int eb =0;

        while(numBottles>0)
        {
            drinking+=numBottles;
            eb += numBottles;
            numBottles = eb / numExchange;
            eb = eb % numExchange;
        }
        return drinking;
    }
}
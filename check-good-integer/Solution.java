class Solution 
{
    public boolean checkGoodInteger(int n) 
    {
        int difference=0;
        while(n>0)
            {
                int digit=n%10;
                difference+=(digit*digit)-digit;
                n/=10;
            }
        return difference>=50;
    }
}
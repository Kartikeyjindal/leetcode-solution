class Solution 
{
    public int getSum(int a, int b) 
    {
        while(b!=0)
        {
            int sumwithoutcarry=a^b;

            int carry=(a&b)<<1;

            a=sumwithoutcarry;
            b=carry;
        }
        return a;
    }
}
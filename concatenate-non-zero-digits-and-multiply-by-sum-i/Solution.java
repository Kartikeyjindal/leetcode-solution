class Solution 
{
    public long sumAndMultiply(int n) 
    {
        long num=0;
        int sum=0;

        while(n>0)
        {
            int dig=n%10;
            if(dig!=0)
            {
                sum+=dig;
                num=num*10+dig;
            }
            n=n/10;
        }
        long rev=reverse(num);
        return (long) rev*sum;
    }

    public long reverse(long n)
    {
        long num=0;
        while(n>0)
        {
            long dig=n%10;
            num=num*10+dig;
            n/=10;
        }
        return num;
    }
}
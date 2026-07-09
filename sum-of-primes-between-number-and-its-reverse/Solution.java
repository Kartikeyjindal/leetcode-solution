class Solution 
{
    public int sumOfPrimesInRange(int n) 
    {
        int rev=reverse(n);

        int min=Math.min(n,rev);
        int max=Math.max(n,rev);
        int sum=0;
        if(min==1)
        {
            min+=1;
        }
        for(int i=min;i<=max;i++)
            {
                if(prime(i))
                {
                    sum+=i;
                }
            }
        return sum;
    }

    public int reverse(int n)
    {
        int ans=0;
        while(n>0)
            {
                int digit=n%10;
                n=n/10;
                ans=ans*10+digit;
            }
        return ans;
    }

    public boolean prime(int n)
    {
        
        for(int i=2;i*i<=n;i++)
            {
                if(n%i==0)
                {
                    return false;
                }
            }
        return true;
    }
}
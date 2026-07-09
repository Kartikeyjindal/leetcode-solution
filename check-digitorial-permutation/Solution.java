class Solution 
{
    int []oarr=new int[10];
    int []narr=new int[10];
    public boolean isDigitorialPermutation(int n) 
    {
        solve(n,oarr);
        long sum=sum(n);
        solve((int)sum,narr);
        if(Arrays.equals(oarr,narr))
        {
            return true;
        }
        return false;
    }
    public long factorial(int n)
    {
        long result=1;
        for(int i=2;i<=n;i++)
            {
                result*=i;
            }
        return result;
        
    }
    public long sum(int n)
    {
        long csum=0;
        int digit=0;
        while(n>0)
        {
            digit=n%10;
            n=n/10;
            csum+=factorial(digit);
        }
        return csum;
    }
    public void solve(int n,int []arr)
    {
        while(n>0)
            {
                int digit=n%10;
                arr[digit]++;
                n=n/10;
            }
    }
}
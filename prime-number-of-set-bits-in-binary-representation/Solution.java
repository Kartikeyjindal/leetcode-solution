class Solution 
{
    public int countPrimeSetBits(int left, int right) 
    {
        int ans=0;
        for(int i=left;i<=right;i++)
        {
            ans+=solve(i);
        }
        return ans;  
    }
    public int solve(int n)
    {
        int count=0;
        for(int i=0;i<32;i++)
        {
            int a=n&1;
            n=n>>1;
            if(a==1)
            {
                count++;
            }
        }
        int ans=0;
        for(int i=1;i*1<=count;i++)
        {
            if(count%i==0)
            {
                ans++;
            }
        }
        if(ans==2)
        {
            return 1;
        }
        return 0;
    }
}
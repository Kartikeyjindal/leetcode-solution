class Solution 
{
    public int mirrorDistance(int n) 
    {
        int reverse=reversed(n);
        int diff=Math.abs(n-reverse);
        return diff;
    }

    public int reversed(int n)
    {
        int ans=0;
        while(n>0)
        {
            int a=n%10;
            ans=ans*10+a;
            n/=10;
        }
        return ans;
    }
}
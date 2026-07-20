class Solution 
{
    public int findGCD(int[] nums) 
    {
        int smallest=Integer.MAX_VALUE;
        int largest=Integer.MIN_VALUE;

        for(int i:nums)
        {
            smallest=Math.min(smallest,i);
            largest=Math.max(largest,i);
        }
        return gcd(smallest,largest);
    }

    public int gcd(int s,int l)
    {
        if(l==0)
        {
            return s;
        }
        return gcd(l,s%l);
    }
}
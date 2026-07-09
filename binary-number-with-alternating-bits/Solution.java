class Solution 
{
    public boolean hasAlternatingBits(int n) 
    {
        int prev=-1;
        while(n>0)
        {
            int curr=n & 1;
            if(prev==curr)
            {
                return false;
            }
            n=n>>1;
            prev=curr;
        }
        return true;
    }
}
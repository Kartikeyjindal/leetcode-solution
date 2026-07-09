class Solution 
{
    public boolean consecutiveSetBits(int n) 
    {
        int pairs=n&(n>>1);

        return Integer.bitCount(pairs)==1;
    }
}
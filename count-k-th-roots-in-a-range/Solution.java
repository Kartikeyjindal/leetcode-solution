class Solution 
{
    public int countKthRoots(int l, int r, int k) 
    {
        long min=(long)Math.ceil(Math.pow(l,1.0/k)-1e-9);
        long max=(long)Math.floor(Math.pow(r,1.0/k)+1e-9);

        return (int)Math.max(0.0,max-min+1);
    }
}
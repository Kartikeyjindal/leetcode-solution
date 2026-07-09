class Solution 
{
    public long zeroFilledSubarray(int[] nums) 
    {
        long ans =0;
        int subans=0;
        for(int num:nums)
        {
            if(num==0)
            {
                subans++;
            }
            else
            {
                subans=0;
            }
            ans+=subans;
        }
        return ans;
    }
}
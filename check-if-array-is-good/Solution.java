class Solution 
{
    public boolean isGood(int[] nums) 
    {
        int n=nums.length;
        if(n==1)
        {
            return false;
        }
        Arrays.sort(nums);
        int k=1;
        int ans=0;
        for(int i=0;i<n-1;i++)
        {
            ans+=nums[i]^k;
            k++;
        }
        if(ans==0 && nums[n-1]==nums[n-2])
        {
            return true;
        }
        return false;
    }
}
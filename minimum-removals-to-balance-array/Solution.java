class Solution 
{
    public int minRemoval(int[] nums, int k) 
    {
        int n=nums.length;
        if(n==1)
        {
            return 0;
        }
        Arrays.sort(nums);
        int ans=1;
        int left=0;
        for(int right=0;right<n;right++)
        {
            while(nums[right]>(long)nums[left]*k)
            {
                left++;
            }
            ans=Math.max(ans,right-left+1);
        }
        return n-ans;
    }
}
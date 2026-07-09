class Solution
{
    public int minMoves2(int[] nums) 
    {
        int n=nums.length;
        int ans=0;
        Arrays.sort(nums);
        if(n%2==0)
        {
            int median=n/2;
            for(int i=0;i<n;i++)
            {
                ans+=Math.abs(nums[i]-nums[median]);
            }
        }
        else
        {
            int median=n/2;
            for(int i=0;i<n;i++)
            {
                ans+=Math.abs(nums[i]-nums[median]);
            }
        }
        return ans;
    }
}
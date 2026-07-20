class Solution 
{
    public int longestConsecutive(int[] nums) 
    {
        Arrays.sort(nums);
        int k=1;
        int ans=0;
        if(nums.length==0)
        {
            return 0;
        }
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i] != nums[i-1])
            {
                if(nums[i] == nums[i-1]+1)
            {
                k++;
            }
            else
            {
               ans=Math.max(ans,k);
               k=1;
            }
            }
        }
        return Math.max(ans,k);
    }
}
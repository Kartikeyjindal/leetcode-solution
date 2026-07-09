class Solution 
{
    public int[] findErrorNums(int[] nums) 
    {
        int n=nums.length;
        Arrays.sort(nums);
        int k=1;
        int dup=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==k)
            {
                k++;
            }
            else if(i>0 && nums[i]==nums[i-1])
            {
                dup=nums[i];
            }
        }
        return new int[]{dup,k};
    }
}
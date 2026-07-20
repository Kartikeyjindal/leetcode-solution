class Solution 
{
    public int majorityElement(int[] nums) 
    {
        int count =1;int a=0;
        int n=nums.length;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[a]==nums[i])
            {
                count++;
            }
            else
            {
                count--;
            }
            if(count==0)
            {
                a=i;
                count=1;
            }
        }
        count=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==nums[a])
            {
                count++;
            }
        }
        if(count > n/2)
        {
            return nums[a];
        }
        return -1;
    }
}
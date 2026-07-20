class Solution 
{
    public int smallestDivisor(int[] nums, int threshold) 
    {
        Arrays.sort(nums);
        int low=1;int high=nums[nums.length-1];
        while(low<high)
        {
            int mid=(low+high)/2;
            if(find(nums,mid,threshold))
            {
                high=mid;
            }
            else
            {
                low=mid+1;
            }
        }
        return low;
    }
    public boolean find(int []nums,int mid,int threshold)
    {
        int hours=0;
        for(int num:nums)
        {
            hours+=(int)Math.ceil((double)num/mid);
        }
        return hours<=threshold;
    }
}
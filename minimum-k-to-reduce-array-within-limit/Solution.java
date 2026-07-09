class Solution 
{
    public int minimumK(int[] nums) 
    {
        int n=nums.length;
        int start=1;
        int max=0;
        for(int i=0;i<n;i++)
            {
                max=Math.max(max,nums[i]);
            }
        int end=Math.max(max,n);
        while(start<end)
            {
                long count=0;
                int mid=start+(end-start)/2;
                for(int i=0;i<n;i++)
                    {
                        count+=(nums[i]+mid-1)/mid;    
                    }
                if(count<=(long)mid*mid)
                {
                    end=mid;
                }
                else
                {
                    start=mid+1;
                }
            }
        return start;
    }
}
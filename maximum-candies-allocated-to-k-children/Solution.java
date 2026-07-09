class Solution 
{
    public int maximumCandies(int[] candies, long k) 
    {
        int total=0;
        int max=0;
        for(int i=0;i<candies.length;i++)
        {
            max=Math.max(max,candies[i]);
            total+=candies[i];
        }
        int ans=0;
        int low=1;
        int high=max;

        while(low<=high)
        {
            int mid=low+(high-low)/2;
            long count=0;
            for(int c:candies)
            {
                count+=c/mid;
            }
            if(count>=k)
            {
                ans=mid;
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return ans;

    }
}
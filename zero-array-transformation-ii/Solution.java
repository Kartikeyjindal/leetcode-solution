class Solution 
{
    public int minZeroArray(int[] nums, int[][] queries) 
    {
        int n=nums.length;
        int l=0;
        int r=queries.length;
        int ans=-1;

        while(l<=r)
        {
            int mid=l+(r-l)/2;

            if(check(mid,nums,queries))
            {
                ans=mid;
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return ans;
    }

    public boolean check(int k,int []nums,int[][]queries)
    {
        int n=nums.length;

        long[]diff=new long[n+1];

        for(int i=0;i<k;i++)
        {
            int l=queries[i][0];
            int r=queries[i][1];
            int val=queries[i][2];

            diff[l]+=val;
            if(r+1<n)
            {
                diff[r+1]-=val;
            }
        }
        int cap=0;
        for(int i=0;i<n;i++)
        {
            cap+=diff[i];

            if(cap<nums[i])
            {
                return false;
            }
        }
        return true;
    }
}
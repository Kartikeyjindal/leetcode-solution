class Solution 
{
    public int xorAfterQueries(int[] nums, int[][] queries) 
    {
        int n=nums.length;
        int q=queries.length;
        int mod=1000000007;
        int ans=0;

        for(int[]a:queries)
        {
            int l=a[0];
            int r=a[1];
            int k=a[2];
            int v=a[3];

            for(int i=l;i<=r;i+=k)
            {
                nums[i]=(int)((1L*nums[i]*v)%mod);
            }
        }
        ans=nums[0];
        for(int i=1;i<n;i++)
        {
            ans=nums[i]^ans;
        }
        return ans;
    }
}
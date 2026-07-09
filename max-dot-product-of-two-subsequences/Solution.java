class Solution 
{
    public int n=0,m=0;
    public int [][]dp;
    public int maxDotProduct(int[] nums1, int[] nums2) 
    {
        n=nums1.length;
        m=nums2.length;
        dp=new int [n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                dp[i][j]=-1;
            }
        }
        return solve(nums1,nums2,0,0);
    }

    public int solve(int []nums1,int []nums2,int i,int j)
    {
        if(i==n||j==m)
        {
            return Integer.MIN_VALUE;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int val=nums1[i]*nums2[j];
        int takeboth=nums1[i]*nums2[j]+Math.max(0,solve(nums1,nums2,i+1,j+1));
        int takei=solve(nums1,nums2,i+1,j);
        int takej=solve(nums1,nums2,i,j+1);

        return dp[i][j]=Math.max(val,Math.max(takeboth,Math.max(takei,takej)));
    }
}
class Solution 
{
    public int[] minCost(int[] nums, int[][] queries) 
    {
        int n=nums.length;
        int []lrcost=new int[n];
        int []rlcost=new int[n];

        for(int i=0;i<n-1;i++)
            {
                int cost=0;
                if(closest(i,i+1,nums))
                {
                    cost=1;
                }
                else
                {
                    cost=Math.abs(nums[i+1]-nums[i]);
                }
                lrcost[i+1]=lrcost[i]+cost;
            }

        for(int i=n-1;i>0;i--)
            {
                int cost=0;
                if(closest(i,i-1,nums))
                {
                    cost=1;
                }
                else
                {
                    cost=Math.abs(nums[i-1]-nums[i]);
                }
                rlcost[i-1]=rlcost[i]+cost;
            }

        int []ans=new int[queries.length];
        int k=0;
        for(int[]q:queries)
            {
                int l=q[0];
                int r=q[1];

                if(l>r)
                {
                    ans[k]=rlcost[r]-rlcost[l];
                }
                else
                {
                    ans[k]=lrcost[r]-lrcost[l];
                }
                k++;
            }
        return ans;
        
    }
    public boolean closest(int x,int target ,int []nums)
    {
        int n=nums.length;
        if(x==n-1)
        {
            return target==n-2;
        }
        if(x==0)
        {
            return target==1;
        }

        int left=nums[x]-nums[x-1];
        int right=nums[x+1]-nums[x];

        if(target==x+1)
        {
            return right<left;
        }
        else
        {
            return left<=right;
        }
    }
}
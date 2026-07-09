class Solution 
{
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) 
    {
        int n=queries.length;
        int []ans=new int[n];
        int m=nums.length;
        int sum=0;
        for(int i:nums)
        {
            if(i%2==0)
            {
                sum+=i;
            }
        }
        int k=0;
        for(int []q:queries)
        {
            int pos=q[1];
            int val=q[0];

            int change=nums[pos];
            if(change%2==0)
            {
                if((change+val)%2==0)
                {
                    sum+=val;
                }
                else
                {
                    sum-=change;
                }
            }
            else
            {
                if((change+val)%2==0)
                {
                    sum+=change+val;
                }
            }
            nums[pos]=change+val;
            ans[k]=sum;
            k++;
        }
        return ans;
    }
}
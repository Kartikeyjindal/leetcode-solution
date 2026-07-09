class Solution 
{
    public boolean isZeroArray(int[] nums, int[][] queries) 
    {
        int n=nums.length;
        int[]arr=new int[n];
        boolean flag=true;
        for(int[]q:queries)
        {
            int l=q[0];
            int r=q[1];
            
            arr[l]+=1;
            if(r+1<n)
            {
                arr[r+1]-=1;
            }
        }
        int cum=0;
        for(int i=0;i<n;i++)
        {
            cum+=arr[i];
            if(cum<nums[i])
            {
                flag=false;;
            }
        }
        return flag;
    }
}
class Solution 
{
    public int minOperations(int[] nums) 
    {
        int n=nums.length;
        int k=-1;
        for(int i=0;i<n;i++)
            {
                if(nums[i]==0)
                {
                    k=i;
                    break;
                }
            }
        boolean inc=true;
        boolean dec=true;

        for(int i=0;i<n;i++)
            {
                if(nums[(k+i)%n]!=i)
                {
                    inc=false;
                }
                if(nums[(k-i+n)%n]!=i)
                {
                    dec=false;
                }
            }
        if(!dec && !inc)
        {
            return -1;
        }

        int ans=Integer.MAX_VALUE;

        if(inc)
        {
            if(k==0)
            {
                ans=Math.min(ans,0);
            }
            else
            {
                ans=Math.min(ans,Math.min(k,n-k+2));
            }
        }
        if(dec)
        {
            ans=Math.min(ans,Math.min(n-k,k+2));
        }
        
        return ans;
    }
}
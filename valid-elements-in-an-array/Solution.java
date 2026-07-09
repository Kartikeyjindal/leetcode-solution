class Solution 
{
    public List<Integer> findValidElements(int[] nums) 
    {
        int n=nums.length;
        List<Integer> ans=new ArrayList<>();

        if(n==0)
        {
            return ans;
        }
        if(n==1)
        {
            ans.add(nums[0]);
            return ans;
        }

        int []sm=new int[n];
        sm[n-1]=Integer.MIN_VALUE;
        for(int i=n-2;i>=0;i--)
            {
                sm[i]=Math.max(sm[i+1],nums[i+1]);
            }
        int pm=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
            {
                if(i==0||i==n-1)
                {
                    ans.add(nums[i]);
                }
                else if(nums[i]>pm||nums[i]>sm[i])
                {
                    ans.add(nums[i]);
                }
                pm=Math.max(pm,nums[i]);
                
            }
        return ans;
    }
}
class Solution 
{
    public List<List<Integer>> threeSum(int[] nums) 
    {
        int n=nums.length;
        Arrays.sort(nums);
        int target;
        List<List<Integer>> ans=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            if(i>0 && nums[i]==nums[i-1])
            {
                continue;
            }
            target=-nums[i];
            twosum(target,i+1,n-1,ans,nums,i);
        }
        return ans;
    }

    public void twosum(int target,int l,int r,List<List<Integer>> ans,int []nums,int i)
    {
        while(l<r)
        {
            int sum=nums[l]+nums[r];
            if(sum>target)
            {
                r--;
            }
            else if(sum<target)
            {
                l++;
            }
            else
            {
                ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                while(l<r && nums[l]==nums[l+1])
                {
                    l++;
                }
                while(l<r && nums[r]==nums[r-1])
                {
                    r--;
                }
                r--;
                l++;
            }
        }
    }
}
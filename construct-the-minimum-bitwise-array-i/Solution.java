class Solution {
    public int[] minBitwiseArray(List<Integer> nums) 
    {
        int n=nums.size();
        int []ans=new int[n];

        for(int i=0;i<n;i++)
        {
            int x=nums.get(i);
            if(x==2)
            {
                ans[i]=-1;
            }
            else
            {
                ans[i]=solve(nums,i);
            }
        }
        return ans;
    }
    public int solve(List<Integer> nums,int a)
    {
        for(int i=0;i<nums.get(a);i++)
        {
            if((i|(i+1))==nums.get(a))
            {
                return i;
            }
        }
        return -1;
    }
}
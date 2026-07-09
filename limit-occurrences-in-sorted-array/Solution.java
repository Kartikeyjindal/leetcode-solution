class Solution 
{
    public int[] limitOccurrences(int[] nums, int k) 
    {
        int n=nums.length;
        ArrayList<Integer> arr=new ArrayList<>();
        int count =0;
        for(int i=0;i<n;i++)
            {
                if(i==0 || nums[i]!=nums[i-1])
                {
                    count =1;
                }
                else
                {
                    count++;
                }
                if(count<=k)
                {
                    arr.add(nums[i]);
                }
            }
        int []ans=new int[arr.size()];
        for(int i=0;i<arr.size();i++)
            {
                ans[i]=arr.get(i);
            }
        return ans;
    }
}
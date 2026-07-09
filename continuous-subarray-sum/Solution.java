class Solution 
{
    public boolean checkSubarraySum(int[] nums, int k) 
    {
        int n=nums.length;
        if(n<2)
        {
            return false;
        }
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
            int rem=sum%k;
            if(map.containsKey(rem))
            {
                int pos=map.get(rem);
                if(i-pos>=2)
                {
                    return true;
                }
            }
            else
            {
                map.put(rem,i);
            }
        }
        return false;
    }
}
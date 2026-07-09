class Solution 
{
    public int minMirrorPairDistance(int[] nums) 
    {
        Map<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        int mindis=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            int reversed=reverse(nums[i]);
            if(map.containsKey(nums[i]))
            {
                mindis=Math.min(mindis,Math.abs(i-map.get(nums[i])));
            }
            map.put(reversed,i);
        }
        return mindis==Integer.MAX_VALUE?-1:mindis;
    }
    public int reverse(int num)
    {
        if (num==0) 
        return 0;
        int ans=0;
        while(num>0)
        {
            int a=num%10;
            ans=ans*10+a;
            num/=10;
        }
        return ans;
    }
}
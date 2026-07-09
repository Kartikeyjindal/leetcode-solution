class Solution 
{
    public int minimumDistance(int[] nums) 
    {
        Map<Integer,List<Integer>> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            map.putIfAbsent(nums[i],new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        int mindis=Integer.MAX_VALUE;

        for(List<Integer> i:map.values())
        {
            if(i.size()>=3)
            {
                for(int idx=0;idx<i.size()-2;idx++)
                {
                    int a=i.get(idx);
                    int b=i.get(idx+2);
                    int dis=2*(b-a);
                    mindis=Math.min(mindis,dis);
                }
            }
        }
        return mindis==Integer.MAX_VALUE?-1:mindis;
    }
}
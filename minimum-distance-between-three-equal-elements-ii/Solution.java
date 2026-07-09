class Solution 
{
    public int minimumDistance(int[] nums) 
    {
        int n=nums.length;
        HashMap<Integer,List<Integer>> map=new HashMap<>();

        for(int i=0;i<n;i++)
        {
            map.putIfAbsent(nums[i],new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        int mindis=Integer.MAX_VALUE;

        for(List<Integer> idx:map.values())
        {
            if(idx.size()>=3)
            {
                for(int i=0;i<idx.size()-2;i++)
                {
                    int a=idx.get(i);
                    int b=idx.get(i+2);

                    int dis=2*(b-a);
                    mindis=Math.min(mindis,dis);
                }
            }
        }
        return mindis==Integer.MAX_VALUE?-1:mindis;
    }
}
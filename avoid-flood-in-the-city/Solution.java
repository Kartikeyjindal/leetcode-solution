class Solution 
{
    public int[] avoidFlood(int[] rains) 
    {
        int n=rains.length;
        int []ans=new int[n];
        Arrays.fill(ans,1);
        Map<Integer,Integer> map=new HashMap<>();
        TreeSet<Integer> set=new TreeSet<>();

        for(int i=0;i<n;i++)
        {
            if(rains[i]==0)
            {
                set.add(i);
            }
            else
            {
                int lake=rains[i];
                ans[i]=-1;
                if(map.containsKey(lake))
                {
                    Integer it=set.ceiling(map.get(lake));
                    if(it==null)
                    {
                        return new int[0];
                    }
                    ans[it]=rains[i];
                    set.remove(it);
                }
                map.put(lake,i);
            }
        }
        return ans ;
    }
}
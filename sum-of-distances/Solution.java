class Solution 
{
    public long[] distance(int[] nums) 
    {
        int n=nums.length;
        long []ans=new long[n];
        HashMap<Integer,List<Integer>> map=new HashMap<>();

        for(int i=0;i<n;i++)
        {
            map.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
        }

        for(Map.Entry<Integer,List<Integer>> entry:map.entrySet())
        {
            Integer key=entry.getKey();
            List<Integer> values=entry.getValue();

            long totalsum=0;
            for(int idx:values)
            {
                totalsum+=idx;
            }
            long prefixsum=0;
            for(int i=0;i<values.size();i++)
            {
                long target=values.get(i);
                long left=(long)(i*target-prefixsum);
                long right=(totalsum-prefixsum-target)-(long)(values.size()-1-i)*target;

                ans[(int)target]=left+right;
                prefixsum+=target;
            }

        }
        return ans;
    }
}
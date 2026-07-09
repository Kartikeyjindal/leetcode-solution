class Solution 
{
    public int findSmallestInteger(int[] nums, int value) 
    {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums)
        {
            int n=((num%value)+value)%value;
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int x=0;
        while(true)
        {
            int rem=x%value;
            if(map.containsKey(rem))
            {
                map.put(rem,map.get(rem)-1);
                if(map.get(rem)==0)
                {
                    map.remove(rem);
                }
                x++;
            }
            else
            {
                break;
            }
        }
        return x;
    }
}
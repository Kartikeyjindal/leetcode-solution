class Solution 
{
    public int[] findOriginalArray(int[] changed) 
    {
        int n=changed.length;
        if(n%2!=0)
        {
            return new int[0];
        }
        Map<Integer,Integer> map=new HashMap<>();
        Arrays.sort(changed);
        for(int i=0;i<n;i++)
        {
            map.put(changed[i],map.getOrDefault(changed[i],0)+1);

        }
        int[]ans=new int[n/2];
        int k=0;

        for(int i=0;i<n;i++)
        {
            int num=changed[i];

            if(map.get(num)==0)
            {
                continue;
            }
            map.put(num,map.get(num)-1);
            int val=2*num;
            if(map.getOrDefault(val,0)==0)
            {
                return new int[0];
            }
            ans[k]=num;
            k++;
            map.put(val,map.get(val)-1);
        }
        return ans;
    }
}
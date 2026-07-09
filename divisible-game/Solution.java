class Solution 
{
    public int divisibleGame(int[] nums) 
    {
        int n=nums.length;
        long[]p=new long[n+1];
        int minnum=Integer.MAX_VALUE;

        for(int i=0;i<n;i++)
            {
                p[i+1]=p[i]+nums[i];
                minnum=Math.min(minnum,nums[i]);
            }
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++)
            {
                int x=nums[i];
                for(int d=1;d*d<=x;d++)
                    {
                        if(x%d==0)
                        {
                            if(d>1)
                            {
                                map.computeIfAbsent(d,k->new ArrayList<>()).add(i);
                            }
                            int d2=x/d;
                                if(d2!=d && d2>1)
                                {
                                    map.computeIfAbsent(d2,k-> new ArrayList<>()).add(i);
                                }
                        }
                    }
            }
        long diff=-minnum;
        int best=2;
        for(Map.Entry<Integer,List<Integer>> entry:map.entrySet())
            {
                int k=entry.getKey();
                List<Integer> indices=entry.getValue();
                long currmax=0;
                long maxsofar=(long)-2e18;
                int previdx=-1;
                for(int idx:indices)
                    {
                        if(previdx==-1)
                        {
                            currmax=nums[idx];
                        }
                        else
                        {
                            long penalty=p[idx]-p[previdx+1];
                            currmax=Math.max((long)nums[idx],currmax-penalty+nums[idx]);
                        }
                        maxsofar=Math.max(maxsofar,currmax);
                        previdx=idx;
                    }
                if(maxsofar>diff || (maxsofar==diff && k<best))
                {
                    diff=maxsofar;
                    best=k;
                }
            }
        long MOD=1_000_000_007;
        long diffmod=diff%MOD;
        if(diffmod<0)
        {
            diffmod+=MOD;
        }
        long kmod=best%MOD;
        return (int)((diffmod*best)%MOD);
    }
}
class Solution 
{
    public int[] productQueries(int n, int[][] queries) 
    {
        int q=queries.length;
        int MOD=1000000007;
        List<Integer> power=new ArrayList<>();
        for(int i=0;i<31;i++)
        {
            if((n>>i&1)==1)
            {
                power.add(1<<i);
            }
        }
        int []ans=new int [q];
        for(int i=0;i<q;i++)
        {
            int left=queries[i][0];
            int right=queries[i][1];
            long product=1;

            for(int j=left;j<=right;j++)
            {
                product=(product*power.get(j))%MOD;
            }
            ans[i]=(int)product;
        }
        return ans;
    }
}
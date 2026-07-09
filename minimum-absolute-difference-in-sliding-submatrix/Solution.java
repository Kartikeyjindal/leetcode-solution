class Solution 
{
    public int[][] minAbsDiff(int[][] grid, int k) 
    {
        int n=grid.length;
        int m=grid[0].length;

        int [][]ans=new int[n-k+1][m-k+1];
        for(int i=0;i<=n-k;i++)
        {
            for(int j=0;j<=m-k;j++)
            {
                List<Integer> v=new ArrayList<>();
                for(int a=i;a<i+k;a++)
                {
                    for(int b=j;b<j+k;b++)
                    {
                        v.add(grid[a][b]);
                    }
                }
                Collections.sort(v);
                int mn=Integer.MAX_VALUE;
                int prev=v.get(0);
                for(int p=1;p<v.size();p++)
                {
                    if(v.get(p)!=prev)
                    {
                        mn=Math.min(mn,v.get(p)-prev);
                    }
                    prev=v.get(p);
                }
                if(mn==Integer.MAX_VALUE)
                {
                    ans[i][j]=0;
                }
                else
                {
                    ans[i][j]=mn;
                }
            }
        }
        return ans;
    }
}
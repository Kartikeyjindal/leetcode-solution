class Solution 
{
    int []parent;
    int []rank;
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) 
    {
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
        }
        Arrays.fill(rank,-1);

        for(int i=0;i<n-1;i++)
        {
            if(Math.abs(nums[i+1]-nums[i])<=maxDiff)
            {
                union(i,i+1);
            }        
        }

        boolean []ans=new boolean[queries.length];
        for(int i=0;i<queries.length;i++)
        {
            int u=queries[i][0];
            int v=queries[i][1];
            ans[i]=(find(u)==find(v));
        }
        return ans;
    }

    public void union(int a,int b)
    {
        int pa=find(a);
        int pb=find(b);

        if(pa==pb)
        {
            return;
        }
        else if(rank[pa]>rank[pb])
        {
            parent[pb]=pa;
        }
        else if(rank[pa]<rank[pb])
        {
            parent[pa]=pb;
        }
        else
        {
            parent[pb]=pa;
            rank[pa]++;
        }
    }

    public int find(int a)
    {
        if(parent[a]==a)
        {
            return a;
        }
        return parent[a]=find(parent[a]);
    }
}
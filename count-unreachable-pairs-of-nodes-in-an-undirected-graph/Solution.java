class Solution 
{
    public long countPairs(int n, int[][] edges) 
    {
        int []parent=new int[n];
        int []rank=new int[n];
        Arrays.fill(rank,0);

        for(int i=0;i<n;i++)
        {
            parent[i]=i;
        }

        for(int []edge:edges)
        {
            union(edge[0],edge[1],parent,rank);
        }

        int[] component=new int[n];
        long  ans=0;

        for(int i=0;i<n;i++)
        {
            component[find(i,parent)]++;
        }

        long remaining=n;

        for(int i=0;i<n;i++)
        {
            if(component[i]>0)
            {
                long size=component[i];
                remaining-=size;

                ans+=remaining*size;
            }
        }

        return ans;
    }
    public int find(int x,int []parent)
    {
        if(parent[x]==x)
        {
            return x;
        }
        return parent[x]=find(parent[x],parent);
    }

    public void union(int x,int y,int[]parent,int[]rank)
    {
        int xparent=find(x,parent);
        int yparent=find(y,parent);

        if(xparent==yparent)
        {
            return ;
        }
        else if(rank[xparent]>rank[yparent])
        {
            parent[yparent]=xparent;
        }
        else if(rank[xparent]<rank[yparent])
        {
            parent[xparent]=yparent;
        }
        else
        {
            parent[xparent]=yparent;
            rank[yparent]++;
        }
    }
}
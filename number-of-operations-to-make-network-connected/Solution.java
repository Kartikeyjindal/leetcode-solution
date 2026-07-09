class Solution 
{
    public int makeConnected(int n, int[][] connections) 
    {
        int m=connections.length;
        int []parent=new int[n];
        int []rank=new int[n];
        Arrays.fill(rank,0);

        for(int i=0;i<n;i++)
        {
            parent[i]=i;
        }

        if(m<n-1)
        {
            return -1;
        }
        int count=n;
        for(int[]edge:connections)
        {
            int xparent=find(edge[0],parent);
            int yparent=find(edge[1],parent);

            if(xparent!=yparent)
            {
                union(edge[0],edge[1],parent,rank);
                count--;
            }
        }
        return count-1;
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
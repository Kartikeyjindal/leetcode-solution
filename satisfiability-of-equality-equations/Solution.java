class Solution 
{
    public boolean equationsPossible(String[] equations) 
    {
        int []parent=new int[26];
        int []rank=new int[26];

        Arrays.fill(rank,0);

        for(int i=0;i<26;i++)
        {
            parent[i]=i;
        }

        for(String s:equations)
        {
            if(s.charAt(1)=='=')
            {
                union(s.charAt(0)-'a',s.charAt(3)-'a',parent,rank);
            }
        }

        for(String s:equations)
        {
            if(s.charAt(1)=='!')
            {
                int xparent=find(s.charAt(0)-'a',parent);
                int yparent=find(s.charAt(3)-'a',parent);

                if(xparent==yparent)
                {
                    return false;
                }
            }
        }

        return true;
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
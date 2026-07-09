class Solution 
{
    int []parent=new int[26];
    int []rank=new int[26];
    public String smallestEquivalentString(String s1, String s2, String base) 
    {
        for(int i=0;i<26;i++)
        {
            parent[i]=i;
        }
        Arrays.fill(rank,-1);
        int n=s1.length();

        for(int i=0;i<n;i++)
        {
            int u=s1.charAt(i)-'a';
            int v=s2.charAt(i)-'a';

            union(u,v);
        }

        StringBuilder ans=new StringBuilder();
        for(int i=0;i<base.length();i++)
        {
            int curr=base.charAt(i)-'a';
            char smallest=(char)(find(curr)+'a');
            ans.append(smallest);
        }
        return ans.toString();
    }

    public void union(int x,int y)
    {
        int xparent=find(x);
        int yparent=find(y);

        if(xparent!=yparent)
        {
            if(xparent<yparent)
            {
                parent[yparent]=xparent;
            }
            else
            {
                parent[xparent]=yparent;
            }
        }
    }

    public int find(int x)
    {
        if(parent[x]==x)
        {
            return x;
        }
        return parent[x]=find(parent[x]);
    }
}
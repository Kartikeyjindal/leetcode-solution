class Solution 
{
    int []parent;
    int []rank;
    public int numberOfGoodPaths(int[] vals, int[][] edges) 
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int n=vals.length;

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int []edge:edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        parent=new int[n];
        rank=new int[n];
        Arrays.fill(rank,1);
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
        }

        //value to {node}
        TreeMap<Integer,ArrayList<Integer>> val=new TreeMap<>();
        for(int i=0;i<n;i++)
        {
            int value=vals[i];
            val.putIfAbsent(value,new ArrayList<>());
            val.get(value).add(i);
        }

        boolean []active=new boolean[n];
        int result=n;

        for(Map.Entry<Integer,ArrayList<Integer>> entry:val.entrySet())
        {
            List<Integer> node=entry.getValue();

            for(int u:node)
            {
                for(int v:adj.get(u))
                {
                    if(active[v])
                    {
                        union(u,v);
                    }
                }
                active[u]=true;
            }

            Map<Integer,Integer> parentcount=new HashMap<>();

            for(int u:node)
            {
                int p=find(u);
                parentcount.put(p,parentcount.getOrDefault(p,0)+1);
            }

            for(int count:parentcount.values())
            {
                result+=(count*(count-1))/2;
            }
        }
        return result;
        


    }

    public int find(int i)
    {
        if(parent[i]==i)
        {
            return i;
        }
        return parent[i]=find(parent[i]);
    }

    public void union(int x,int y)
    {
        int xp=find(x);
        int yp=find(y);

        if(rank[xp]>rank[yp])
        {
            parent[yp]=xp;
        }
        else if(rank[xp]<rank[yp])
        {
            parent[xp]=yp;
        }
        else
        {
            parent[xp]=yp;
            rank[yp]++;
        }
    }
}
class Solution 
{
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) 
    {
        ArrayList<ArrayList<int []>>adj=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int []f:flights)
        {
            adj.get(f[0]).add(new int[]{f[1],f[2]});
        }

        int []dis=new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        int level=0;

        Queue<int []> queue=new LinkedList<>();
        queue.add(new int[]{src,0});
        dis[src]=0;

        while(!queue.isEmpty() && level<=k)
        {
            int size=queue.size();
            level++;
            for(int i=0;i<size;i++)
            {
                int []cur=queue.poll();
                int node=cur[0];
                int cost=cur[1];

                for(int []neighbor:adj.get(node))
                {
                    int nextnode=neighbor[0];
                    int price=neighbor[1];

                    if(cost+price<dis[nextnode])
                    {
                        dis[nextnode]=cost+price;
                        queue.add(new int[]{nextnode,dis[nextnode]});
                    }
                }
            }

        }
        if(dis[dst]==Integer.MAX_VALUE)
        {
            return -1;
        }
        return dis[dst];
    }
}
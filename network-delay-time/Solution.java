class Solution 
{
    public int networkDelayTime(int[][] times, int n, int k) 
    {
        ArrayList<ArrayList<int []>>adj=new ArrayList<>();
        
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int []edge:times)
        {
            int nodea=edge[0];
            int nodeb=edge[1];
            int weight=edge[2];

            adj.get(nodea).add(new int[]{nodeb,weight});
        }

        int []dis=new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);

        dis[k]=0;
        PriorityQueue<int []>pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{k,0});

        while(!pq.isEmpty())
        {
            int []cur=pq.poll();
            int node=cur[0];
            int curweight=cur[1];
            if(curweight>dis[node])
            {
                continue;
            }

            for(int []neighbor:adj.get(node))
            {
                int adjnode=neighbor[0];
                int adjweight=neighbor[1];

                if(curweight+adjweight<dis[adjnode])
                {
                    dis[adjnode]=curweight+adjweight;
                    pq.add(new int[]{adjnode,dis[adjnode]});
                }
            }
        }

        int maxdis=0;
        for(int i=1;i<=n;i++)
        {
            if(dis[i]==Integer.MAX_VALUE)
            {
                return -1;
            }
            maxdis=Math.max(maxdis,dis[i]);
            
        }
        return maxdis;
    }
}
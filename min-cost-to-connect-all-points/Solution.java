class Solution 
{
    public int minCostConnectPoints(int[][] points) 
    {
        int n=points.length;
        ArrayList<ArrayList<int []>>adj=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int dis=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);

                adj.get(j).add(new int[]{i,dis});
                adj.get(i).add(new int[]{j,dis});
            }
        }

        PriorityQueue<int []>pq=new PriorityQueue<>((a,b)->a[1]-b[1]);

        pq.add(new int[]{0,0});
        int ans=0;
        int edgeuse=0;
        boolean []visited=new boolean[n];

        while(!pq.isEmpty())
        {
            int []cur=pq.poll();
            int node=cur[0];
            int dis=cur[1];

            if(visited[node])
            {
                continue;
            }

            visited[node]=true;
            ans+=dis;
            edgeuse++;

            if(edgeuse==n)
            {
                break;
            }

            for(int []neighbor:adj.get(node))
            {
                int adjnode=neighbor[0];
                int adjdis=neighbor[1];

                if(!visited[adjnode])
                {
                    pq.add(new int[]{adjnode,adjdis});
                }

            }
        }
        return ans;
        
    }
}
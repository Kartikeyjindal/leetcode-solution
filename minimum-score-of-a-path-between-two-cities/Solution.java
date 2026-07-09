class Solution 
{
    public int minScore(int n, int[][] roads) 
    {
        ArrayList<ArrayList<int []>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int []r:roads)
        {
            adj.get(r[0]).add(new int[]{r[1],r[2]});
            adj.get(r[1]).add(new int[]{r[0],r[2]});
        }

        Queue<Integer> queue=new LinkedList<>();
        queue.add(1);
        boolean []visited=new boolean[n+1];
        int dis=Integer.MAX_VALUE;
        visited[1]=true;

        while(!queue.isEmpty())
        {
            int cur=queue.poll();

            for(int []neighbor:adj.get(cur))
            {
                int nextnode=neighbor[0];
                int dist=neighbor[1];
                dis=Math.min(dis,dist);
                if(!visited[nextnode])
                {
                    queue.add(nextnode);
                    visited[nextnode]=true;
                }

            }
        }
        return dis;
    }
}
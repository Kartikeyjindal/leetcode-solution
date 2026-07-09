class Solution 
{
    public int minReorder(int n, int[][] connections) 
    {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        //1=> for the given connection
        //0=> for the reversed connection
        for(int []c:connections)
        {
            adj.get(c[0]).add(new int[]{c[1],1});
            adj.get(c[1]).add(new int[]{c[0],0});
        }

        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        int ans=0;
        boolean []visited=new boolean[n];
        visited[0]=true;

        while(!queue.isEmpty())
        {
            int cur=queue.poll();

            for(int []neighbor:adj.get(cur))
            {
                int nextnode=neighbor[0];
                int dir=neighbor[1];
                if(!visited[nextnode])
                {
                    if(dir==1)
                    {
                        ans++;
                    }
                    queue.add(nextnode);
                    visited[nextnode]=true;
                }
            }
        }
        return ans;
    }
}
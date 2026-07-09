class Solution 
{
    public boolean possibleBipartition(int n, int[][] dislikes) 
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int []dis:dislikes)
        {
            adj.get(dis[0]).add(dis[1]);
            adj.get(dis[1]).add(dis[0]);
        }

        int []color=new int[n+1];
        //Two colors 0 and 1
        Arrays.fill(color,-1);

        for(int i=1;i<=n;i++)
        {
            if(color[i]==-1)
            {
                Queue<Integer> queue=new LinkedList<>();
                queue.add(i);
                color[i]=0;
                
                while(!queue.isEmpty())
                {
                    int cur=queue.poll();

                    for(int neighbor:adj.get(cur))
                    {
                        if(color[neighbor]==color[cur])
                        {
                            return false;
                        }
                        if(color[neighbor]==-1)
                        {
                            color[neighbor]=1-color[cur];
                            queue.add(neighbor);
                        }
                    }
                }
            }
        }
        return true;
    }
}
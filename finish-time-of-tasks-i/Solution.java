class Solution 
{
    public long finishTime(int n, int[][] edges, int[] basetime) 
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int []edge:edges)
        {
            int parent=edge[0];
            int child=edge[1];
            adj.get(parent).add(child);
        }
        return dfs(0,adj,basetime);
    }

    public long dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] basetime)
    {
        if(adj.get(node).isEmpty())
        {
            return basetime[node];
        }
        long earliest=Long.MAX_VALUE;
        long latest=Long.MIN_VALUE;

        for(int child:adj.get(node))
        {
            long childtime=dfs(child,adj,basetime);

            earliest=Math.min(earliest,childtime);
            latest=Math.max(latest,childtime);
        }
        long own=(latest-earliest)+basetime[node];
        return own+latest;
    }
}
class Solution 
{
    public int minTime(int n, int[][] edges, List<Boolean> hasapple) 
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int []dis:edges)
        {
            adj.get(dis[0]).add(dis[1]);
            adj.get(dis[1]).add(dis[0]);
        }

       return  dfs(adj,0,-1,hasapple);
    }

    public int dfs(ArrayList<ArrayList<Integer>> adj,int node,int parent,List<Boolean> hasapple)
    {
        int time=0;

        for(int child:adj.get(node))
        {
            if(child==parent)
            {
                continue;
            }

            int timechild=dfs(adj,child,node,hasapple);

            if(timechild>0 || hasapple.get(child)==true)
            {
                time+=timechild+2;
            }
        }
        return time;
    }
}
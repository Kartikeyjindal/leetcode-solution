class Solution 
{
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) 
    {
        int n=graph.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<graph[i].length;j++)
            {
                adj.get(i).add(graph[i][j]);
            }
        }

        dfs(0,n-1,adj,new ArrayList<>());
        return ans;
    }

    public void dfs(int node,int target,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> sol)
    {
        sol.add(node);

        if(node==target)
        {
            ans.add(new ArrayList<>(sol));
        }

        for(int neighbor:adj.get(node))
        {
            dfs(neighbor,target,adj,sol);
        }
        sol.remove(sol.size()-1);
    }
}
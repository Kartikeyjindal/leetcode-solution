class Solution 
{
    public int findCircleNum(int[][] isConnected) 
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int n=isConnected.length;

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(isConnected[i][j]==1 && i!=j)
                {
                    adj.get(i).add(j);
                }
            }
        }

        boolean []visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                dfs(i,adj,visited);
                count++;
            }
        }
        return count;
    }

    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean []visited)
    {
        visited[node]=true;

        for(int neighbor:adj.get(node))
        {
            if(!visited[neighbor])
            {
                dfs(neighbor,adj,visited);
            }
        }
    }
}
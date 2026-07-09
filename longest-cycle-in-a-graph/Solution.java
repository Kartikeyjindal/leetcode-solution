class Solution 
{
    boolean []visited;
    boolean []pathvisited;
    int []dis;
    int ans=0;
    public int longestCycle(int[] edges)
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int n=edges.length;

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++)
        {
            adj.get(i).add(edges[i]);
        }

        visited=new boolean[n];
        pathvisited=new boolean[n];
        dis=new int[n];

        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                dfs(i,adj,0);
            }
        }
        if(ans==0)
        {
            return -1;
        }
        return ans;
    }

    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,int currdis)
    {
        dis[node]=currdis;
        visited[node]=true;
        pathvisited[node]=true;
        for(int neighbor:adj.get(node))
        {
            if(neighbor!=-1)
            {
                if(!visited[neighbor])
                {
                    dfs(neighbor,adj,currdis+1);
                }
                if(pathvisited[neighbor])
                {
                    int cycledis=dis[node]-dis[neighbor]+1;
                    ans=Math.max(ans,cycledis);
                }
            }
        }
        pathvisited[node]=false;
    }
}
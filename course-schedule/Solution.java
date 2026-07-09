class Solution 
{
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int []edge:prerequisites)
        {
            adj.get(edge[0]).add(edge[1]);
        }

        boolean []visited=new boolean[numCourses];
        boolean []pathvisited=new boolean[numCourses];

        for(int i=0;i<numCourses;i++)
        {
            if(!visited[i])
            {
                if(dfs(i,adj,visited,pathvisited))
                {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean []visited ,boolean []pathvisited)
    {
        visited[node]=true;
        pathvisited[node]=true;

        for(int neighbor:adj.get(node))
        {
            if(!visited[neighbor])
            {
                if(dfs(neighbor,adj,visited,pathvisited))
                {
                    return true;
                }
            }
            else if(pathvisited[neighbor])
            {
                return true;
            }
        }
        pathvisited[node]=false;
        return false;
    }
}
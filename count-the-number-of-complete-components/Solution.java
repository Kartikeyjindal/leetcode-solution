class Solution 
{
    public int countCompleteComponents(int n, int[][] edges) 
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[]e:edges)
        {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean []visited=new boolean[n];
        int result=0;

        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                int[] counts = new int[2];
                dfs(i,counts,visited,adj);
                int v=counts[0];
                int e=counts[1];
                if((v*(v-1))==e)
                {
                    result++;
                }
            }
        }
        return result;
    }

    public void dfs(int i,int []count,boolean []visited,ArrayList<ArrayList<Integer>> adj)
    {
        visited[i]=true;

        count[1]+=adj.get(i).size();
        count[0]++;
        for(int neighbor:adj.get(i))
        {
            if(!visited[neighbor])
            {
                dfs(neighbor,count,visited,adj);
            }
        }
    }
}
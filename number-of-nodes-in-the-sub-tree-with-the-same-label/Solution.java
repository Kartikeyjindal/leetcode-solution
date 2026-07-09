class Solution 
{
    int []ans;
    public int[] countSubTrees(int n, int[][] edges, String labels) 
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
        ans=new int[n];

        dfs(0,-1,labels,adj);
        return ans;
    }

    public int[] dfs(int node,int parent,String labels,ArrayList<ArrayList<Integer>> adj)
    {
        int[] nodecount=new int[26];

        char target=labels.charAt(node);
        nodecount[target-'a']=1;

        for(int neighbor:adj.get(node))
        {
            if(neighbor==parent)
            {
                continue;
            }
            int []childcount=dfs(neighbor,node,labels,adj);

            for(int i=0;i<26;i++)
            {
                nodecount[i]+=childcount[i];
            }
        }
        ans[node]=nodecount[target-'a'];
        return nodecount;
    }
}
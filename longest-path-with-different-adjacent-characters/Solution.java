class Solution 
{
    int ans=0;
    public int longestPath(int[] parent, String s) 
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        int n=parent.length;
        for (int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i=1;i<n;i++)
        {
            adj.get(parent[i]).add(i);
        }
        dfs(0,adj,s);
        return ans;
    }

    public int dfs(int node,ArrayList<ArrayList<Integer>> adj,String s)
    {
        int max1=0;
        int max2=0;

        for(int child:adj.get(node))
        {
            int childlength=dfs(child,adj,s);

            if(s.charAt(node)!=s.charAt(child))
            {
                if(childlength>max1)
                {
                    max2=max1;
                    max1=childlength;
                }
                else if(childlength>max2)
                {
                    max2=childlength;
                }
            }
        }
        ans=Math.max(ans,max1+max2+1);

        return max1+1;
    }
}
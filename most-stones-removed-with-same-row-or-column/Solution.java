class Solution 
{
    boolean []visited;
    public int removeStones(int[][] stones) 
    {
        int n=stones.length;
        visited=new boolean[n];

        int count=0;

        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                dfs(i,stones);
                count++;
            }
        }
        return n-count;
    }

    public void dfs(int node,int[][] stones)
    {
        visited[node]=true;

        for(int i=0;i<stones.length;i++)
        {
            int r=stones[node][0];
            int c=stones[node][1];

            if(!visited[i] && (stones[i][0]==r || stones[i][1]==c))
            {
                dfs(i,stones);
            }
        }
    }
}
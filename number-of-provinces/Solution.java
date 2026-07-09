class Solution 
{
    public int findCircleNum(int[][] isConnected) 
    {
        int n=isConnected.length;
        int [] visited=new int[n];
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(visited[i]==0)
            {
                dfs(isConnected,visited,n,i);
                count++;
            }
        }
        return count;
    }
    public void dfs(int[][] isConnected,int []visited,int n,int i)
    {
        visited[i]=1;
        for(int v=0;v<n;v++)
        {
            if(visited[v]==0 && isConnected[i][v]==1)
            {
                dfs(isConnected,visited,n,v);
            }
        }
    }
}
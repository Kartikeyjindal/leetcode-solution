class Solution 
{
    int []node1ans;
    int []node2ans;
    int n;
    ArrayList<ArrayList<Integer>> adj;
    public int closestMeetingNode(int[] edges, int node1, int node2) 
    {
        adj=new ArrayList<>();
        n=edges.length;

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++)
        {
            if (edges[i] != -1) 
            {
                adj.get(i).add(edges[i]);
            }
        }
        boolean []visited1=new boolean[n];
        boolean []visited2=new boolean[n];
        node1ans=bfs(node1,visited1);
        node2ans=bfs(node2,visited2);

        int []nodeans=new int[n];
        for(int i=0;i<n;i++)
        {
            if (node1ans[i] != Integer.MAX_VALUE && node2ans[i] != Integer.MAX_VALUE) 
            {
                nodeans[i] = Math.max(node1ans[i], node2ans[i]);
            } 
            else 
            {
                nodeans[i] = Integer.MAX_VALUE;
            }
        }
        int min=Integer.MAX_VALUE;
        int idx=-1;
        for(int i=0;i<n;i++)
        {
            if(nodeans[i]<min)
            {
                min=nodeans[i];
                idx=i;
            }
        }
        return idx;
    }

    public int[] bfs(int node,boolean []visited)
    {
        int []ans=new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        visited[node]=true;
        Queue<Integer> queue=new LinkedList<>();
        queue.add(node);
        ans[node]=0;

        while(!queue.isEmpty())
        {
            int cur=queue.poll();
            for(int neighbor:adj.get(cur))
            {
                if(!visited[neighbor])
                {
                    visited[neighbor]=true;
                    queue.add(neighbor);
                    ans[neighbor]=1+ans[cur];
                }
            }
        }
        return ans;
    }
}
class Solution 
{
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }
        int[]indegree=new int[numCourses];
        for(int []edge:prerequisites)
        {
            adj.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                queue.add(i);
            }
        }
        int count=0;
        while(!queue.isEmpty())
        {
            int curr=queue.poll();
            count++;
            for(int neighbor:adj.get(curr))
            {
                indegree[neighbor]--;
                if(indegree[neighbor]==0)
                {
                    queue.add(neighbor);
                }
                
            }
        }
        if(count==numCourses)
        {
            return true;
        }
        return false;
    }
}
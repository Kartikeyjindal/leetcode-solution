class Solution 
{
    public boolean canVisitAllRooms(List<List<Integer>> rooms) 
    {
        int n=rooms.size();

        boolean []visited=new boolean[n];
        Queue<Integer> queue=new LinkedList<>();

        queue.add(0);
        visited[0]=true;

        while(!queue.isEmpty())
        {
            int cur=queue.poll();

            for(int neighbor:rooms.get(cur))
            {
                if(!visited[neighbor])
                {
                    queue.add(neighbor);
                    visited[neighbor]=true;
                }
            }
        }

        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                return false;
            }
        }
        return true;
    }
}
class Solution 
{
    public int nearestExit(char[][] maze, int[] entrance) 
    {
        int m=maze.length;
        int n=maze[0].length;

        Queue<int []> queue=new LinkedList<>();
        queue.add(entrance);

        int [][]dir={{1,0},{-1,0},{0,1},{0,-1}};
        int ans=0;

        boolean [][]visited=new boolean[m][n];
        visited[entrance[0]][entrance[1]] = true;

        while(!queue.isEmpty())
        {
            int size=queue.size();
            
            for(int i=0;i<size;i++)
            {
                int []cur=queue.poll();
                int r=cur[0];
                int c=cur[1];

                for(int []d:dir)
                {
                    int newr=r+d[0];
                    int newc=c+d[1];

                    if(newr >= 0 && newr < m && newc >= 0 && newc < n && maze[newr][newc] == '.' && !visited[newr][newc])
                    {
                        if(newr == 0 || newr == m - 1 || newc == 0 || newc == n - 1)
                        {
                            return ans + 1; 
                        }
                        queue.add(new int[]{newr, newc});
                        visited[newr][newc] = true;
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
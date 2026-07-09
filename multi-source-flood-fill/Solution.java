class Solution 
{
    public int[][] colorGrid(int n, int m, int[][] sources) 
    {
        int [][]grid=new int[n][m];
        int [][]visited=new int[n][m];

        for(int[] row:visited)
            {
                Arrays.fill(row,-1);
            }
        Arrays.sort(sources,(a,b)->b[2]-a[2]);
        Queue<int []> queue=new LinkedList<>();

        for(int []s:sources)
            {
                int r=s[0];
                int c=s[1];
                int color=s[2];
                grid[r][c]=color;
                visited[r][c]=0;
                queue.add(new int[]{r,c,color,0});
            }
        int [][]dir={{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty())
            {
                int[]cur=queue.poll();
                int r=cur[0];
                int c=cur[1];
                int color=cur[2];
                int time=cur[3];

                for(int[]d:dir)
                    {
                        int nr=r+d[0];
                        int nc=c+d[1];
                        if(nr>=0 && nr<n && nc>=0 && nc<m)
                        {
                            if(visited[nr][nc]==-1)
                                {
                                    visited[nr][nc]=time+1;
                                    grid[nr][nc]=color;
                                    queue.add(new int[]{nr,nc,color,time+1});
                                }
                        }
                    }
            }
        return grid;
    }
}
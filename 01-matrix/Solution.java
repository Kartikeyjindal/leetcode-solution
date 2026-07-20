class Solution 
{
    public int[][] updateMatrix(int[][] mat) 
    {
        if (mat == null || mat.length == 0 || mat[0].length == 0)
        {
            return new int[0][0];
        }

        int m=mat.length;
        int n=mat[0].length;
        int [][]distance=new int[m][n];
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]>queue=new LinkedList<>();

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j] == 0)
                {
                    distance[i][j]=0;
                    queue.offer(new int[]{i,j});
                }
                else
                {
                    distance[i][j]=-1;
                }
            }
        }
        while(!queue.isEmpty())
        {
            int []current=queue.poll();
            int row=current[0];
            int col=current[1];

            for(int []direc:directions)
            {
                int newrow=row+direc[0];
                int newcol=col+direc[1];

                if(newrow>=0 && newcol>=0 && newrow<m && newcol<n && distance[newrow][newcol]==-1)
                {
                    distance[newrow][newcol]=distance[row][col]+1;
                    queue.add(new int[]{newrow,newcol});
                }
            }
        }
        return distance;
    }
}
class Solution 
{
    public int shortestPathBinaryMatrix(int[][] grid) 
    {
        int n=grid.length;

        if(grid[0][0]==1 || grid[n-1][n-1]==1)
        {
            return -1;
        }

        Queue<int []>queue=new LinkedList<>();
        queue.add(new int[]{0,0,1});
        //{row,col,pathlength}

        grid[0][0]=1;

        int [][]direction={{-1, -1}, {-1, 0}, {-1, 1},{0, -1}, {0, 1},{1, -1},  {1, 0},  {1, 1}};

        while(!queue.isEmpty())
        {
            int []cur=queue.poll();
            int row=cur[0];
            int col=cur[1];
            int dis=cur[2];

            if(row==n-1 && col==n-1)
            {
                return dis;
            }

            for(int []dir:direction)
            {
                int newrow=row+dir[0];
                int newcol=col+dir[1];

                if(newrow>=0 && newrow<n && newcol>=0 && newcol<n &&grid[newrow][newcol]==0)
                {
                    queue.add(new int[]{newrow,newcol,dis+1});
                    grid[newrow][newcol]=1;
                }
            }
        }
        return -1;
    }
}
class Solution 
{
    public int minimumEffortPath(int[][] heights) 
    {
        int n=heights.length;
        int m=heights[0].length;

        int [][]effort=new int[n][m];
        for(int []row:effort)
        {
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        effort[0][0]=0;
        int [][]direction={{0,1},{-1,0},{0,-1},{1,0}};

        PriorityQueue<int []>pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,0});

        while(!pq.isEmpty())
        {
            int []cur=pq.poll();
            int r=cur[0];
            int c=cur[1];
            int ceffort=cur[2];

            if(r==n-1 && c==m-1)
            {
                return ceffort;
            }

            if(ceffort>effort[r][c])
            {
                continue;
            }

            for(int []dir:direction)
            {
                int newrow=r+dir[0];
                int newcol=c+dir[1];

                if(newrow>=0 && newrow<n && newcol>=0 && newcol<m)
                {
                    int jump=Math.abs(heights[r][c]-heights[newrow][newcol]);
                    int maxeffort=Math.max(ceffort,jump);

                    if(maxeffort<effort[newrow][newcol])
                    {
                        effort[newrow][newcol]=maxeffort;
                        pq.add(new int[]{newrow,newcol,maxeffort});
                    }
                }
            }
        }
        return 0;
        
    }
}
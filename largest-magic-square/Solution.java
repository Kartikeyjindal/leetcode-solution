class Solution 
{
    public int largestMagicSquare(int[][] grid) 
    {
        int m=grid.length;
        int n=grid[0].length;
        int side=Math.min(m,n);

        while(side>0)
        {
            for(int i=0;i+side<=m;i++)
            {
                for(int j=0;j+side<=n;j++)
                {
                    if(isvalid(grid,m,n,i,j,side))
                    {
                        return side;
                    }
                }
            }
            side--;
        }
        return 0;
    }

    public boolean isvalid(int [][]grid,int m,int n,int i,int j,int side)
    {
        int sum=0;
        //row
        for(int x=i;x<i+side;x++)
        {
            int summ=0;
            for(int y=j;y<j+side;y++)
            {
                summ+=grid[x][y];
            }
            if(x==i)
            {
                sum=summ;
            }
            else if(sum!=summ)
            {
                return false;
            }
        }
        //col
        for(int x=j;x<j+side;x++)
        {
            int summ=0;
            for(int y=i;y<i+side;y++)
            {
                summ+=grid[y][x];
            }
            if(sum!=summ)
            {
                return false;
            }
        }

        //diag
        int summ=0;
        for(int k=0;k<side;k++)
        {
            summ+=grid[i+k][j+k];
        }
        if(sum!=summ)
        {
            return false;
        }

        //anti diag
        summ=0;
        for(int k=0;k<side;k++)
        {
            summ+=grid[i+k][j+side-1-k];
        }
        if(sum!=summ)
        {
            return false;
        }
        return true;

    }
}
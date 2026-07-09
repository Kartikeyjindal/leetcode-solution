class Solution 
{
    public int numMagicSquaresInside(int[][] grid) 
    {
        int row=grid.length;
        int col=grid[0].length;

        int count=0;
        //
        for(int i=0;i<=row-3;i++)
        {
            for(int j=0;j<=col-3;j++)
            {
                if(magic(i,j,grid))
                {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean magic(int r,int c,int [][]grid)
    {
        //Number check
        Set<Integer> set=new HashSet<Integer>();
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                int num=grid[r+i][c+j];

                if(num<1||num>9||set.contains(num))
                {
                    return false;
                }
                else
                {
                    set.add(num);
                }
            }
        }

        //Sum
        int sum=grid[r][c]+grid[r][c+1]+grid[r][c+2];

        for(int i=0;i<3;i++)
        {
            if(grid[r+i][c]+grid[r+i][c+1]+grid[r+i][c+2]!=sum)
            {
                return false;
            }
            if(grid[r][c+i]+grid[r+1][c+i]+grid[r+2][c+i]!=sum)
            {
                return false;
            }
        }
        //diag
        if(grid[r][c]+grid[r+1][c+1]+grid[r+2][c+2]!=sum)
        {
            return false;
        }
        //anti diag
        if(grid[r][c+2]+grid[r+1][c+1]+grid[r+2][c]!=sum)
        {
            return false;
        }
        return true;
    }
}
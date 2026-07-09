class Solution 
{
    public int minSwaps(int[][] grid) 
    {
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<grid.length;i++)
        {
            int zero=0;
            for(int j=grid.length-1;j>=0;j--)
            {
                if(grid[i][j]==0)
                {
                    zero++;
                }
                else
                {
                    break;
                }
            }
            arr.add(zero);
        }
        int swap=0;
        for(int i=0;i<grid.length;i++)
        {
            int need=grid.length-i-1;
            int j=i;
            while(j<grid.length && arr.get(j)<need)
            {
                j++;
            }
            if(j==grid.length)
            {
                return -1;
            }
            while(j>i)
            {
                int temp=arr.get(j);
                arr.set(j,arr.get(j-1));
                arr.set(j-1,temp);
                j--;
                swap++;
            }
        }
        return swap;
    }
}
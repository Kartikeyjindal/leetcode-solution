class Solution 
{
    public int largestSubmatrix(int[][] matrix) 
    {
        int n=matrix.length;
        int m=matrix[0].length;
        int maxarea=0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==1 && i>0)
                {
                    matrix[i][j]+=matrix[i-1][j];
                }
            }

            int[] height=matrix[i].clone();
            Arrays.sort(height);
            for(int a=0;a<m;a++)
            {
                int h=height[a];
                int base=m-a;
                maxarea=Math.max(maxarea,h*base);
            }
        }
        
        return maxarea;
    }
}
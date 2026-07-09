class Solution 
{
    public List<Integer> spiralOrder(int[][] matrix) 
    {
        List<Integer> ans=new ArrayList<>();
        int m=matrix.length;
        int n=matrix[0].length;

        int dir=0;//dir=0 ltor. dir=1 ttob. dir=2 rtol. dir=3 btot. 
        int top=0;
        int bottom=m-1;
        int left=0;
        int right=n-1;

        while(top<=bottom && left<=right)
        {
            if(dir==0)
            {
                for(int i=left;i<=right;i++)
                {
                    ans.add(matrix[top][i]);
                }
                top++;
                dir++;
            }
            else if(dir==1)
            {
                for(int i=top;i<=bottom;i++)
                {
                    ans.add(matrix[i][right]);
                }
                right--;
                dir++;
            }
            else if(dir==2)
            {
                for(int i=right;i>=left;i--)
                {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
                dir++;
            }
            else
            {
                for(int i=bottom;i>=top;i--)
                {
                    ans.add(matrix[i][left]);
                }
                left++;
                dir=0;
            }
        }
        return ans;
    }
}
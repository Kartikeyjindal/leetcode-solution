class Solution 
{
    public boolean findRotation(int[][] mat, int[][] target) 
    {
        int count=0;
        while(count<4)
        {
            count++;
            if(check(mat,target))
            {
                return true;
            }
            mat=rotate(mat);
        }
        return false;
    }

    public boolean check(int[][]mat,int[][]target)
    {
        int n=mat.length;
        int m=mat[0].length;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]!=target[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] rotate(int[][]mat)
    {
        int n=mat.length;
        int m=mat[0].length;
        int[][]ans=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                ans[j][n-1-i]=mat[i][j];
            }
        }
        return ans;
    }
}
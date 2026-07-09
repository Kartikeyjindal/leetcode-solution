class Solution 
{
    public int []result;
    public boolean[][]visited;
    public int n,m,idx=0;
    public int[] findDiagonalOrder(int[][] mat) 
    {
        n=mat.length;
        m=mat[0].length;
        result=new int[n*m];
        visited=new boolean[n][m];
        solve(0,0,true,mat);
        return result;
    }
    public void solve(int i,int j,boolean up,int[][]mat)
    {
        if(i<0||j<0||i>=n||j>=m||visited[i][j])
        {
            return;
        }
        result[idx++]=mat[i][j];
        visited[i][j]=true;

        if(up)
        {
            if(i-1>=0 && j+1<m) {
                solve(i-1,j+1,true,mat);
            } else {
                if(j+1<m) solve(i,j+1,false,mat);
                else solve(i+1,j,false,mat);
            }
        }
        else
        {
            if(i+1<n && j-1>=0) {
                solve(i+1,j-1,false,mat);
            } else {
                if(i+1<n) solve(i+1,j,true,mat);
                else solve(i,j+1,true,mat);
            }
        }
    }
}
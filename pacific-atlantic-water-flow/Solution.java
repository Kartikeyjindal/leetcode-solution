class Solution 
{
    boolean [][]pacific;
    boolean [][]atlantic;
    int[][]dir;
    int m;
    int n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) 
    {
        List<List<Integer>> ans=new ArrayList<>();
        m=heights.length;
        n=heights[0].length;
        pacific=new boolean[m][n];
        atlantic=new boolean[m][n];

        dir=new int[][]{{1,0},{-1,0},{0,-1},{0,1}};

        for(int i=0;i<n;i++)
        {
            dfs(heights,0,i,Integer.MIN_VALUE,pacific);
            dfs(heights,m-1,i,Integer.MIN_VALUE,atlantic);
        }

        for(int i=0;i<m;i++)
        {
            dfs(heights,i,0,Integer.MIN_VALUE,pacific);
            dfs(heights,i,n-1,Integer.MIN_VALUE,atlantic);
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(pacific[i][j] && atlantic[i][j])
                {
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
        
    }

    public void dfs(int[][] heights,int i,int j,int prev,boolean [][] matrix)
    {
        if(i>=m || j>=n || i<0 || j<0 || matrix[i][j]==true || heights[i][j]<prev)
        {
            return ;
        }

        matrix[i][j]=true;
        for(int []d:dir)
        {
            int nr=i+d[0];
            int nc=j+d[1];
            dfs(heights,nr,nc,heights[i][j],matrix);
        }
    }
}

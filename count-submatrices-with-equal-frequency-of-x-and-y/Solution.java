class pair
{
    int a;
    int b;
    pair(int a,int b)
    {
        this.a=a;
        this.b=b;
    }
}
class Solution 
{
    public int numberOfSubmatrices(char[][] grid) 
    {
        int n=grid.length;
        int m=grid[0].length;
        pair[][]p=new pair[n][m];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='X')
                {
                    p[i][j]= new pair(1,0);
                }
                else if(grid[i][j]=='Y')
                {
                    p[i][j]= new pair(0,1);
                }
                else
                {
                    p[i][j]= new pair(0,0);
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                p[i][j].a+=p[i][j-1].a;
                p[i][j].b+=p[i][j-1].b;
            }
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                p[i][j].a+=p[i-1][j].a;
                p[i][j].b+=p[i-1][j].b;
            }
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(p[i][j].a>0 && p[i][j].b==p[i][j].a)
                {
                    ans++;
                }
            }
        }
        return ans;
    }
}
class Solution 
{
    public int robotSim(int[] commands, int[][] obstacles) 
    {
        Set<String> st=new HashSet<>();

        for(int []obs:obstacles)
        {
            st.add(obs[0]+","+obs[1]);
        }
        int [][] dir={{0,1},{1,0},{0,-1},{-1,0}};

        int x=0,y=0,d=0,maxdis=0;

        for(int cms:commands)
        {
            if(cms==-1)
            {
                d=(d+1)%4;
            }
            else if(cms==-2)
            {
                d=(d+3)%4;
            }
            else
            {
                for(int i=0;i<cms;i++)
                {
                    int nx=x+dir[d][0];
                    int ny=y+dir[d][1];

                    if(st.contains(nx+","+ny))
                    {
                        break;
                    }
                    x=nx;
                    y=ny;
                    maxdis=Math.max(maxdis,x*x+y*y);
                }
            }
        }
        return maxdis;
    }
}
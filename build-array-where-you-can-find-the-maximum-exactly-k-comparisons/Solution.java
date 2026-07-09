class Solution 
{
    public int MOD=1000000007;
    public int N,M,K;
    public int[][][]dp;
    public int numOfArrays(int n, int m, int k) 
    {
            N=n;
            M=m;
            K=k;
            dp=new int[51][N+1][101];
        for (int i = 0; i < 51; i++) 
        {
            for (int j = 0; j <= N; j++) 
            {
                Arrays.fill(dp[i][j], -1);
        }
        }
        return solve(0,0,0);
    }

    public int solve(int index,int searchcost,int max )
    {
        if(index == N)
        {
            if(searchcost == K)
            {
                return 1;
            }
            return 0;
        }

        if(dp[index][searchcost][max] != -1)
        {
            return dp[index][searchcost][max];
        }
        int result=0;
        for(int i=1;i<=M;i++)
        {
            if(i > max)
            {
                result=(result+solve(index+1,searchcost+1,i))%MOD;
            }
            else
            {
                result=(result+solve(index+1,searchcost,max))%MOD;
            }
        }
        return dp[index][searchcost][max]=result%MOD;
    }
}
class Solution 
{
    int [][]dp;
    public int findLongestChain(int[][] pairs) 
    {
        dp=new int[pairs.length][pairs.length+1];

        for(int []a:dp)
        {
            Arrays.fill(a,-1);
        }

        Arrays.sort(pairs,(a,b)->{
            if(a[0]==b[0])
            {
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });

        return solve(0,-1,pairs);
    }

    public int solve(int i,int prev,int [][]pairs)
    {
        if(i>=pairs.length)
        {
            return 0;
        }
        if(dp[i][prev+1]!=-1)
        {
            return dp[i][prev+1];
        }
        int take=0;
        if(prev==-1 || pairs[prev][1]<pairs[i][0])
        {
            take=1+solve(i+1,i,pairs);
        }
        int leave=solve(i+1,prev,pairs);

        return dp[i][prev+1]=Math.max(take,leave);
    }
}
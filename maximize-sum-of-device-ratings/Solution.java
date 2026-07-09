class Solution 
{
    public long maxRatings(int[][] units) 
    {
        int m=units.length;
        int n=units[0].length;

        if(n==1)
        {
            long sum=0;
            for(int i=0;i<m;i++)
                {
                    sum+=units[i][0];
                }
            return sum;
        }
        int [][]min=new int[m][2];
        long basesum=0;

        for(int i=0;i<m;i++)
            {
                int u=Integer.MAX_VALUE;
                int v=Integer.MAX_VALUE;

                for(int j=0;j<n;j++)
                    {
                        int x=units[i][j];
                        if(x<u)
                        {
                            v=u;
                            u=x;
                        }
                        else if(x<v)
                        {
                            v=x;
                        }
                    }
                min[i][0]=u;
                min[i][1]=v;
                basesum+=u;
            }
        Arrays.sort(min,(a,b)->Integer.compare(a[0],b[0]));

        long[] sufv=new long[m+1];
        int [] sufmin=new int[m+1];
        sufmin[m]=Integer.MAX_VALUE;

        for(int i=m-1;i>=0;i--)
            {
                sufv[i]=sufv[i+1]+min[i][1];
                sufmin[i]=Math.min(sufmin[i+1],min[i][1]);
            }
        long maxsum=basesum;
        long pref=0;

        for(int k=0;k<m;k++)
            {
            int M=min[k][0];
            long curr=pref+sufv[k]-sufmin[k]+M;
            maxsum=Math.max(maxsum,curr);
            pref+=M;
            }
        return maxsum;
    }
}
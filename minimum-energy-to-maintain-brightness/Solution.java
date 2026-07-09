class Solution 
{
    public long minEnergy(int n, int brightness, int[][] intervals) 
    {
        if(brightness==0||intervals.length==0||intervals==null)
        {
            return 0;
        }

        long min=(brightness+2)/3;

        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        long activetime=0;
        int start=intervals[0][0];
        int end=intervals[0][1];

        for(int i=1;i<intervals.length;i++)
            {
                if(intervals[i][0]<=end)
                {
                    end=Math.max(end,intervals[i][1]);
                }
                else
                {
                    activetime+=(end-start+1L);
                    start=intervals[i][0];
                    end=intervals[i][1];
                }
            }

        activetime+=(end-start+1L);
        return min*activetime;
    }
}
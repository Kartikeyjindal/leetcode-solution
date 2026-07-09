class Solution 
{
    public int eraseOverlapIntervals(int[][] intervals) 
    {
        Arrays.sort(intervals,(a,b)->{
            if(a[1]==b[1])
            {
                return a[0]-b[0];
            }
            return a[1]-b[1];
        });

        int ans=0;
        int end=intervals[0][1];

        int n=intervals.length;
        for(int i=1;i<n;i++)
        {
            if(end>intervals[i][0])
            {
                ans++;
            }
            else
            {
                end=intervals[i][1];
            }
        }
        return ans;
    }
}
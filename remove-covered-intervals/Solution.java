class Solution 
{
    public int removeCoveredIntervals(int[][] intervals) 
    {
        int n=intervals.length;
        List<int []> arr=new ArrayList<>();

        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0])
            {
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });

        int prev=0;
        arr.add(new int[]{intervals[0][0],intervals[0][1]});

        for(int i=1;i<n;i++)
        {
            if(intervals[prev][1]<intervals[i][1])
            {
                arr.add(new int[]{intervals[i][0],intervals[i][1]});
                prev=i;
            }
        }
        return arr.size();
    }
}
class Solution 
{
    public int countDays(int days, int[][] meetings) 
    {
        int n=meetings.length;

        Arrays.sort(meetings, (a,b)->a[0]-b[0]);

        int start=0;
        int result=0;
        int end=0;

        for(int []meeting:meetings)
        {
            if(meeting[0]>end)
            {
                result += meeting[0] - end - 1;
            }
            end = Math.max(end, meeting[1]);
        }

        if(days>end)
        {
            result+=days-end;
        }
        return result;

    }
}
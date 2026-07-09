class Solution 
{
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) 
    {
        int n=landStartTime.length;
        int m=waterStartTime.length;
        int ans=Integer.MAX_VALUE;

        for(int i=0;i<n;i++)
            {
            for(int j=0;j<m;j++)
                {
                    int finishland = landStartTime[i] + landDuration[i];
                    int finishwatertoland = Math.max(finishland, waterStartTime[j]) + waterDuration[j];
                    
                    int finishwater = waterStartTime[j] + waterDuration[j];
                    int finishlandtowater = Math.max(finishwater, landStartTime[i]) + landDuration[i];
                    
                    ans = Math.min(ans, Math.min(finishwatertoland, finishlandtowater));
                }
            }
        return ans;
    }
}
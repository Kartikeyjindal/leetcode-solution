class Solution 
{
    public long maximumHappinessSum(int[] happiness, int k) 
    {
        Arrays.sort(happiness);
        long ans=0;
        int count=0;
        int n=happiness.length-1;
        while(count<k)
        {
            ans+=Math.max(0L,happiness[n]-count);
            n--;
            count++;
        }
        return ans;
    }
}
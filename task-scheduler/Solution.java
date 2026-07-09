class Solution 
{
    public int leastInterval(char[] tasks, int n) 
    {
        int []freq=new int[26];
        int maxfreq=0;

        for(char task:tasks)
        {
            freq[task-'A']++;
            maxfreq=Math.max(maxfreq,freq[task-'A']);
        }

        int maxcount=0;
        for(int f:freq)
        {
            if(f==maxfreq)
            {
                maxcount++;
            }
        }
        int interval=(maxfreq-1)*(n+1)+maxcount;

        return Math.max(interval,tasks.length);
    }
}
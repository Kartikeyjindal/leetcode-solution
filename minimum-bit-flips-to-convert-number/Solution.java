class Solution 
{
    public int minBitFlips(int start, int goal) 
    {
        int ans=0;
        int count=0;

        ans=start^goal;

        while(ans != 0)
        {
            if((ans & 1)==1 )
            {
                count++;
            }
            ans=ans>>1;
        }
        return count;
    }
}
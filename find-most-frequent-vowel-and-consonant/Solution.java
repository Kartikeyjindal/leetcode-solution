class Solution 
{
    public int maxFreqSum(String s) 
    {
        int []freq=new int [26];
        int maxvowel=0;
        int maxconso=0;
        for(char c:s.toCharArray())
        {
            int i=c-'a';
            freq[i]++;
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            {
                maxvowel=Math.max(maxvowel,freq[i]);
            }
            else
            {
                maxconso=Math.max(maxconso,freq[i]);
            }
        }
        return maxconso+maxvowel;
    }
}
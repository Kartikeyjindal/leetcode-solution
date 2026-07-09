class Solution 
{
    public int vowelConsonantScore(String str) 
    {
        int v = 0;
        int c = 0;

        for (char s : str.toCharArray())
        {
            if (s >= 'a' && s <= 'z')   // only letters
            {
                if (s=='a'||s=='e'||s=='i'||s=='o'||s=='u')
                {
                    v++;
                }
                else
                {
                    c++;
                }
            }
        }

        if (c == 0)
        {
            return 0;
        }

        return (int)Math.floor((double)v / c);
    }
}

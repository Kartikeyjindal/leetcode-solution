class Solution 
{
    public int countBinarySubstrings(String s) 
    {
       int zero = 0;
       int one = 0;
       int i = 0;
       int count = 0;
       char prev = '2';

       while(i < s.length())
       {
            char ch = s.charAt(i);

            if(ch == '0')
            {
                if(prev == '0')
                {
                    zero++;
                }
                else
                {
                    count += Math.min(zero, one);
                    zero = 1;
                }
                prev = '0';
            }
            else 
            {
                if(prev == '1')
                {
                    one++;
                }
                else
                {
                    count += Math.min(zero, one);
                    one = 1;
                }
                prev = '1';
            }
            i++;
       }
       count += Math.min(zero, one);

       return count;
    }
}

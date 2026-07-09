class Solution 
{
    public int compress(char[] chars) 
    {
        int index=0;
        int i=0;

        while(i<chars.length)
        {
            char ch=chars[i];
            int count=0;

            while(i<chars.length && chars[i]==ch)
            {
                i++;
                count++;
            }
            chars[index++]=ch;
            if(count >1)
            {
                String cs=Integer.toString(count);
                for(char c:cs.toCharArray())
                {
                    chars[index++]=c;
                }
            }
        }
        return index;
    }
}
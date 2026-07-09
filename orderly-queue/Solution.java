class Solution 
{
    public String orderlyQueue(String s, int k) 
    {
        if(k>1)
        {
            char ch[]=s.toCharArray();
            Arrays.sort(ch);
            return String.valueOf(ch);
        }
        else
        {
            String newstr=s;
            for(int i=0;i<s.length();i++)
            {
                s=s.substring(1)+s.substring(0,1);
                if(newstr.compareTo(s)>0)
                {
                    newstr=s;
                }
            }
            return newstr;
        }
    }
}
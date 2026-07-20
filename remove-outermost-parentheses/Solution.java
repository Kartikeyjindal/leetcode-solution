class Solution 
{
    public String removeOuterParentheses(String s) 
    {
        String s1="";
        int c=0;
        int a=0;int b;
        char [] ch = s.toCharArray();
        for(int i=0 ; i <= s.length()-1 ; i++)
        {
            if(ch[i] =='(')
            {
                if(c==0)
                {
                    c++;
                }

                else if(c>0)
                {
                    c++;
                    s1=s1+ch[i];
                }
            }

            else if(ch[i]==')')
            {
                if(c==1)
                {
                    c--;
                }

                else if(c>1)
                {
                    c--;
                    s1=s1+ch[i];
                }
            }
        }
        return s1;        
    }
}
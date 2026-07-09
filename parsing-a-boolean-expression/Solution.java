class Solution 
{
    public boolean parseBoolExpr(String e) 
    {
        Stack<Character> s=new Stack<>();
        Stack<Character> o=new Stack<>();

        for(char c:e.toCharArray())
        {
            if(c=='&' || c=='|' || c=='!')
            {
                o.push(c);
            }
            else if(c=='('|| c=='t' || c=='f')
            {
                s.push(c);
            }
            else if(c==')')
            {
                boolean htrue=false;
                boolean hfalse=false;
                while(s.peek()!='(')
                {
                    char ch=s.pop();
                    if(ch=='f')
                    {
                        hfalse=true;
                    }
                    else
                    {
                        htrue=true;
                    }
                }
                s.pop();
                char op=o.pop();
                if(op=='|')
                {
                    s.push(htrue?'t':'f');
                }
                else if(op=='&')
                {
                    s.push(hfalse?'f':'t');
                }
                else
                {
                    s.push(htrue?'f':'t');
                }
            }
        }
        return s.pop()=='t';
    }
}
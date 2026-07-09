class Solution 
{
    public int calculate(String s) 
    {
        int n=s.length();
        Stack<Integer> st=new Stack<>();
        int result=0;
        int num=0;
        int sign=1;

        for(char ch:s.toCharArray())
        {
            if(Character.isDigit(ch))
            {
                num=num*10+(ch-'0');
            }
            else if(ch=='+')
            {
                result+=(num*sign);
                sign=1;
                num=0;
            }
            else if(ch=='-')
            {
                result+=(num*sign);
                sign=-1;
                num=0;
            }
            else if(ch=='(')
            {
                st.push(result);
                st.push(sign);
                result=0;
                sign=1;
                num=0;
            }
            else if(ch==')')
            {
                result+=(num*sign);
                num=0;
                int stsign=st.pop();
                int stnum=st.pop();

                result=result*stsign;
                result+=stnum;
            }
        }
        result+=(num*sign);
        return result;
    }
}
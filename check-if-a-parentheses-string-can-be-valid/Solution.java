class Solution 
{
    public boolean canBeValid(String s, String l) 
    {
        int n=s.length();
        if(n%2!=0)
        {
            return false;
        }
        Stack<Integer> open=new Stack<>();
        Stack<Integer> openclose=new Stack<>();

        for(int i=0;i<n;i++)
        {
            if(l.charAt(i)=='0')
            {
                openclose.push(i);
            }
            else if(s.charAt(i)=='(')
            {
                open.push(i);
            }
            else if(s.charAt(i)==')')
            {
                if(open.isEmpty() && openclose.isEmpty())
                {
                    return false;
                }
                else if(!open.isEmpty())
                {
                    open.pop();
                }
                else if(!openclose.isEmpty())
                {
                    openclose.pop();
                }
            }
        }
        while(!open.isEmpty() && !openclose.isEmpty() && open.peek()<openclose.peek())
        {
            open.pop();
            openclose.pop();
        }
        if(!open.isEmpty())
        {
            return false;
        }
        return true;
    }
}
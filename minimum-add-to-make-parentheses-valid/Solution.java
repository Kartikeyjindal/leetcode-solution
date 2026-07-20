class Solution 
{
    public int minAddToMakeValid(String s) 
    {
        Stack<Character> stack=new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(!stack.isEmpty())
            {
                char last=stack.peek();
                if(ispair(ch,last))
                {
                    stack.pop();
                    continue;
                }
            }
            stack.push(ch);
        }
        return stack.size();
    }

    public boolean ispair(char cur, char last)
    {
           return (last == '(' && cur == ')') ||
                (last == '{' && cur == '}') ||
               (last == '[' && cur == ']');
    }
}
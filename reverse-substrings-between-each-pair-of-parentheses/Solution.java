class Solution 
{
    public String reverseParentheses(String s) 
    {
        Stack<String> stack=new Stack<>();
        int n=s.length();

        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(ch!=')')
            {
                stack.push(String.valueOf(ch));
            }
            else
            {
                StringBuilder sb=new StringBuilder();
                while(!stack.isEmpty() && !stack.peek().equals("("))
                {
                    sb.append(new StringBuilder(stack.pop()).reverse());
                }
                stack.pop();
                stack.push(sb.toString());
            }
        }
        StringBuilder ans=new StringBuilder();
        while(!stack.isEmpty())
        {
            ans.insert(0,stack.pop());
        }
        return ans.toString();
    }
}
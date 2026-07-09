class Solution 
{
    public String removeStars(String str) 
    {
        Stack<Character> stack=new Stack<>();

        for(char s:str.toCharArray())
        {
            if(s=='*')
            {
                stack.pop();
            }
            else
            {
                stack.push(s);
            }
        }
        StringBuilder ans=new StringBuilder();
        while(!stack.isEmpty())
        {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}
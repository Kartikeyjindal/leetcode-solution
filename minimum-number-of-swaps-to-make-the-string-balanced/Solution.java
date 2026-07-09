class Solution 
{
    public int minSwaps(String s) 
    {
       Stack<Character> stack=new Stack<>();

       for(char ch:s.toCharArray())
       {
            if(!stack.isEmpty() && stack.peek()=='[' && ch==']')
            {
                stack.pop();
            }
            else if(ch=='[')
            {
                stack.push(ch);
            }
       } 
        return (stack.size()+1)/2;
    }
}
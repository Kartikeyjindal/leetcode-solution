class Solution 
{
    public int minimumDeletions(String s) 
    {
        Stack<Character> stack=new Stack<>();
        int ans=0;
        for(char ch:s.toCharArray())
        {
            if(!stack.isEmpty() && stack.peek()=='b' && ch=='a')
            {
                ans++;
                stack.pop();
            }
            else
            {
                stack.push(ch);
            }
        }
        return ans;
    }
}
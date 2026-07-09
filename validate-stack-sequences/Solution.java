class Solution 
{
    public boolean validateStackSequences(int[] pushed, int[] popped) 
    {
        int n=pushed.length;
        Stack<Integer> stack=new Stack<>();
        int k=0;

        for(int val:pushed)
        {
            stack.push(val);
            while(!stack.isEmpty() && stack.peek()==popped[k])
            {
                stack.pop();
                k++;
            }
        }
        return stack.isEmpty();
    }
}
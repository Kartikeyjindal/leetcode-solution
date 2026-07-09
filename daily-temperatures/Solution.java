class Solution 
{
    public int[] dailyTemperatures(int[] temp) 
    {
        int n=temp.length;
        int []ans=new int[n];

        Stack<Integer> stack=new Stack<>();

        for(int i=n-1;i>=0;i--)
        {
            while(!stack.isEmpty() && temp[i]>=temp[stack.peek()])
            {
                stack.pop();
            }
            if(stack.isEmpty())
            {
                ans[i]=0;
            }
            else
            {
                ans[i]=stack.peek()-i;
            }
            stack.push(i);
        }

        return ans;
    }
}
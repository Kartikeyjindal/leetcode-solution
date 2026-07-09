class Solution 
{
    public int[] asteroidCollision(int[] asteroids) 
    {
        Stack<Integer> stack=new Stack<>();
        
        for(int val:asteroids)
        {
            boolean flag=false;
            while(!stack.isEmpty() && stack.peek()>0 && val<0)
            {
                int top=stack.peek();
                int current=Math.abs(val);

                if(top<current)
                {
                    stack.pop();
                }
                else if(top==current)
                {
                    stack.pop();
                    flag=true;
                    break;
                }
                else
                {
                    flag=true;
                    break;
                }
            }
            if(!flag)
            {
                stack.push(val);
            }
        }
        int []ans=new int[stack.size()];
        for(int i=stack.size()-1;i>=0;i--)
        {
            ans[i]=stack.pop();
        }
        return ans;

    }
}
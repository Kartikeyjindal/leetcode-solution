class Solution 
{
    public int trap(int[] height) 
    {
        Stack<Integer> stack=new Stack<>();
        int n=height.length;
        int ans=0;

        for(int i=0;i<n;i++)
        {
            while(!stack.isEmpty() && height[i]>height[stack.peek()])
            {
                int bottom=stack.pop();
                if(stack.isEmpty())
                {
                    break;
                }
                int left=stack.peek();
                int h=Math.min(height[left],height[i])-height[bottom];
                int width=i-left-1;
                ans+=h*width;
            }
            stack.add(i);
        }
        return ans;
    }
}
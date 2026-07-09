class Solution 
{
    public boolean find132pattern(int[] nums) 
    {
        int n3=Integer.MIN_VALUE;
        Stack<Integer> st=new Stack<>();
        int n=nums.length;
        for(int i=n-1;i>=0;i--)
        {
            if(nums[i]<n3)
            {
                return true;
            }
            while(!st.isEmpty() && nums[i]>st.peek())
            {
                n3=st.pop();
            }
            st.push(nums[i]);
        }
        return false;
    }
}
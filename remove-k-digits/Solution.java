class Solution 
{
    public String removeKdigits(String nums, int k) 
    {
        int n=nums.length();
        if(n==k || n==0)
        {
            return "0";
        }
        Stack<Integer> stack=new Stack<>();
        stack.push(nums.charAt(0)-'0');
        for(int i=1;i<n;i++)
        {
            while(k>0 && !stack.isEmpty() &&stack.peek()>nums.charAt(i)-'0')
            {
                stack.pop();
                k--;
            }
            stack.push(nums.charAt(i)-'0');
        }
        while(k>0 && !stack.isEmpty())
        {
            stack.pop();
            k--;
        }
        StringBuilder ans=new StringBuilder();
        while(!stack.isEmpty())
        {
            ans.append(stack.pop());
        }
        ans.reverse();
        while(ans.length()>1 && ans.charAt(0)=='0')
        {
            ans.deleteCharAt(0);
        }
        return ans.length()==0?"0":ans.toString();
    }
}
class Solution 
{
    public List<Integer> replaceNonCoprimes(int[] nums) 
    {
        Stack<Integer> stack=new Stack<>();

        for(int i:nums)
        {
            while(!stack.isEmpty())
            {
                int prev=stack.peek();
                int curr=i;

                if(gcd(prev,curr)==1)
                {
                    break;
                }
                stack.pop();
                int lcm=prev/gcd(prev,curr)*curr;
                i=lcm;
            }
            stack.push(i);
        }
        List<Integer> ans=new ArrayList<>();
        while(!stack.isEmpty())
        {
            ans.add(stack.pop());
        }
        Collections.reverse(ans);
        return ans;
    }

    public int gcd(int a,int b)
    {
        if(b==0)
        {
            return Math.abs(a);
        }
        return gcd(b,a%b);
    }
}


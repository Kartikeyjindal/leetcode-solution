class Solution 
{
    public String minRemoveToMakeValid(String s) 
    {
        int n=s.length();
        Stack<Integer>stack=new Stack<>();
        HashSet<Integer> map=new HashSet<>();

        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
            {
                stack.push(i);
            }
            else if(ch==')')
            {
                if(!stack.isEmpty())
                {
                    stack.pop();
                }
                else
                {
                    map.add(i);
                }
            }
        }
        while(!stack.isEmpty())
        {
            map.add(stack.pop());
        }

        StringBuilder ans=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            if(!map.contains(i))
            {
                ans.append(s.charAt(i));
            }
        }
        
        return ans.toString();
    }
}
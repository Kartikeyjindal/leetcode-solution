class Solution 
{
    public String removeOccurrences(String s, String parts) 
    {
        Stack<Character> stack=new Stack<>();
        int n=s.length();
        int m=parts.length();

        for(int i=0;i<n;i++)
        {
            stack.push(s.charAt(i));
            if(stack.size()>=m)
            {
                boolean match=true;
                for(int j=0;j<m;j++)
                {
                    if(stack.get(stack.size()-m+j)!=parts.charAt(j))
                    {
                        match=false;
                        break;
                    }
                }
                if(match)
                {
                    for(int j=0;j<m;j++)
                    {
                        stack.pop();
                    }
                }
            }
        }
        String ans="";
        while(!stack.isEmpty())
        {
            ans=stack.pop()+ans;
        }
        return ans;
    }
}
import java.util.*;
class Solution 
{
    public String simplifyPath(String path) 
    {
        StringTokenizer st=new StringTokenizer(path,"/");
        Stack<String> stack=new Stack<>();
        while(st.hasMoreTokens())
        {
            String next=st.nextToken();

            if(next.equals(".."))
            {
                if(!stack.isEmpty())
                {
                    stack.pop();
                }
            }
            else if(next.equals(".")|| next.isEmpty())
            {
                continue;
            }
            else
            {
                stack.push(next);
            }
        }
        StringBuilder result=new StringBuilder();

        for(String dir:stack)
        {
            result.append("/").append(dir);
        }
        return result.length()==0?"/":result.toString();
    }
}
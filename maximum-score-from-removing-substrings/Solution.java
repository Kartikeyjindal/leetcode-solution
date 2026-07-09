import java.util.*;
class Solution 
{
    public int maximumGain(String s, int x, int y) 
    {
        int ans=0;
        int first=Math.max(x,y);
        char ff=(x>y)?'a':'b';
        char fs=(x>y)?'b':'a';

        int second=Math.min(x,y);
        char sf=(x>y)?'b':'a';
        char ss=(x>y)?'a':'b';

        Stack<Character> stack=new Stack<>();

        for(char c:s.toCharArray())
        {
            if(!stack.isEmpty() && ff==stack.peek() && fs==c)
            {
                stack.pop();
                ans+=first;
            }
            else
            {
                stack.push(c);
            }
        }
        Stack<Character> secondstack=new Stack<>();
        for(char c:stack)
        {
            if(!secondstack.isEmpty() && sf==secondstack.peek() && c==ss)
            {
                secondstack.pop();
                ans+=second;
            }
            else
            {
                secondstack.push(c);
            }
        }
        return ans;
    }
}
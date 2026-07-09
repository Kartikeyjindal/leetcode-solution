// class pair
// {
//     int a;int b;
//     pair(int a,int b)
//     {
//         this.a=a;
//         this.b=b;
//     }
// }
class Solution 
{
    public int evalRPN(String[] tokens) 
    {
        Stack<Integer> stack=new Stack<>();

        for(String s:tokens)
        {
            if(s.equals("+"))
            {
                int a=stack.pop();
                int b=stack.pop();

                stack.push(a+b);
            }
            else if(s.equals("-"))
            {
                int a=stack.pop();
                int b=stack.pop();

                stack.push(b-a);
            }
            else if(s.equals("*"))
            {
                int a=stack.pop();
                int b=stack.pop();

                stack.push(a*b);
            }
            else if(s.equals("/"))
            {
                int a=stack.pop();
                int b=stack.pop();
                int div=b/a;
                stack.push(div);
            }
            else if(s.matches("^-?\\d+"))
            {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();

    }
}
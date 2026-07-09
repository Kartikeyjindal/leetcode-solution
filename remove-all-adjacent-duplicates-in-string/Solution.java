class Solution 
{
    Stack<Character> st=new Stack<>();
    public String removeDuplicates(String s) 
    {
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            if(!st.isEmpty())
            {
                char a=s.charAt(i);
                char b=st.peek();
                if(a==b)
                {
                    st.pop();
                } 
                else
                {
                    st.push(s.charAt(i));
                }
            }
            else
            {
                st.push(s.charAt(i));
            }
        }
        String ans="";
        while(!st.isEmpty())
        {
            ans+=st.pop();
        }
        return new StringBuilder(ans).reverse().toString();
    }
}
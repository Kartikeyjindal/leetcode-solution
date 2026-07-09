class Solution 
{
    public String processStr(String s) 
    {
        StringBuilder sb=new StringBuilder();
        int n=s.length();

        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);

            if(ch!='*' && ch!='#' && ch!='%')
            {
                sb.append(ch);
            }
            else if(ch=='*')
            {
                if(sb.length()>0)
                {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            else if(ch=='%')
            {
                sb.reverse();
            }
            else if(ch=='#')
            {
                String st=sb.toString();
                sb.append(st);
            }
        }
        return sb.toString();

    }
}
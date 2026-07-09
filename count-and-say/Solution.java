class Solution 
{
    public String countAndSay(int n) 
    {
        if(n==1)
        {
            return "1";
        }
        String prev=countAndSay(n-1);
        return solve(prev);
    } 

    public String solve(String s)
    {
        StringBuffer result=new StringBuffer();
        int n=s.length();
        int count=1;
        for(int i=1;i<n;i++)
        {
            if(s.charAt(i)==s.charAt(i-1))
            {
                count++;
            }
            else
            {
                result.append(count);
                result.append(s.charAt(i-1));
                count=1;
            }
        }
        result.append(count);
        result.append(s.charAt(n-1));
        return result.toString();
    }
}
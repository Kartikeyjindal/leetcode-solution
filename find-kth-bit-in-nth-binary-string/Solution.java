class Solution 
{
    public char findKthBit(int n, int k) 
    {
        String result=solve(n);
        return result.charAt(k-1);
    }
    public String solve(int n)
    {
        if(n==1)
        {
            return "0";
        }
        String prev=solve(n-1);
        String inv=invert(prev);
        String rev=reverse(inv);
        return prev+"1"+rev;
    }
    public String invert(String s)
    {
        StringBuilder sb=new StringBuilder(s);
        int n=sb.length();
        for(int i=0;i<n;i++)
        {
            if(sb.charAt(i)=='1')
            {
                sb.setCharAt(i,'0');
            }
            else
            {
                sb.setCharAt(i,'1');
            }
        }
        return sb.toString();
    }
    public String reverse(String s)
    {
        StringBuilder sb=new StringBuilder(s);
        return sb.reverse().toString();
    }
}
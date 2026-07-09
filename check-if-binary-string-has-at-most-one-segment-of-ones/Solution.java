class Solution 
{
    public boolean checkOnesSegment(String s) 
    {
       int n=s.length();
       if(n==1)
       {
        return true;
       }
       for(int i=1;i<n;i++)
       {
            if(s.charAt(i)=='1' && s.charAt(i-1)=='0')
            {
                return false;
            }
       } 
       return true;
    }
}
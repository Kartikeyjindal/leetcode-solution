class Solution 
{
    public int minFlips(String s)
    {
        int n=s.length();
        if(n==1)
        {
            return 0;
        }
        int one=0;
        int zero=0;
        boolean flag=false;

        for(char ch:s.toCharArray())
            {
                if(ch=='1')
                {
                    one++;
                }
                else
                {
                    zero++;
                }
            }
        if(s.charAt(0)=='1')
        {
            one--;
            flag=true;
        }
        if(s.charAt(n-1)=='1')
        {
            one--;
            flag=true;
        }
        if(flag==false)
        {
            one--;
        }
        int ans= Math.min(one,zero);
        if(ans<0)
        {
            return 0;
        }
        return ans;
    }
}
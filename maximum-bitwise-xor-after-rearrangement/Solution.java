class Solution 
{
    public String maximumXor(String s, String t) 
    {
        int n = s.length();
        
        String se = t;
        
        int sets = 0;
        int sett = 0;
        
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < n; i++)
        {
            if(s.charAt(i) == '1')
                sets++;
            
            if(se.charAt(i) == '1')
                sett++;
        }
        
        int nsets = n - sets;
        int nsett = n - sett;
        
        for(int i = 0; i < n; i++)
        {
            char ch = s.charAt(i);
            
            if(ch == '0')
            {
                if(sett > 0)
                {
                    result.append('1');
                    sett--;
                }
                else
                {
                    result.append('0');
                    nsett--;
                }
            }
            else
            {
                if(nsett > 0)
                {
                    result.append('1');
                    nsett--;
                }
                else
                {
                    result.append('0');
                    sett--;
                }
            }
        }
        
        return result.toString();
    }
}
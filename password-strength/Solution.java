class Solution 
{
    public int passwordStrength(String password) 
    {
        int n=password.length();
        int sum=0;
        int lower=0;
        int upper=0;
        int dig=0;
        int special=0;
        boolean []seen=new boolean[128];
        for(char ch:password.toCharArray())
            {
                if(seen[ch])
                {
                    continue;
                }
                seen[ch]=true;
                if(Character.isLowerCase(ch))
                {
                    lower++;
                }
                else if(Character.isUpperCase(ch))
                {
                    upper++;
                }
                else if(Character.isDigit(ch))
                {
                    dig++;
                }
                else if(ch=='!' || ch=='@' || ch=='#' || ch=='$')
                {
                    special++;
                }
            }
        sum=lower*1+upper*2+dig*3+special*5;
        return sum;
    }
}
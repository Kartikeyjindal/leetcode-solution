class Solution 
{
    public int numSteps(String s) 
    {
        int steps=0;
        StringBuilder sh=new StringBuilder(s);
        while(!sh.toString().equals("1"))
        {
            if(sh.charAt(sh.length()-1)=='0')
            {
                sh.deleteCharAt(sh.length()-1);
            }
            else
            {
                int i=sh.length()-1;
                while(i>=0 && sh.charAt(i)=='1')
                {
                    sh.setCharAt(i,'0');
                    i--;
                }
                if(i>=0)
                {
                    sh.setCharAt(i,'1');
                }
                else
                {
                    sh.insert(0,'1');
                }
            }
            steps++;
        }
        return steps;
    }
}
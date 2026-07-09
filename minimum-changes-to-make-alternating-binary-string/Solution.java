class Solution 
{
    public int minOperations(String s) 
    {
        int n = s.length();
        int op1 = 0;
        int op2 = 0;

        for(int i=0;i<n;i++)
        {
            char expected1 =(i%2==0)?'0':'1';
            char expected2 =(i%2==0)?'1':'0';

            if(s.charAt(i)!= expected1)
                op1++;

            if(s.charAt(i)!= expected2)
                op2++;
        }

        return Math.min(op1, op2);
    }
}
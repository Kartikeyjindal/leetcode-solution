class Solution 
{
    public boolean judgeCircle(String moves) 
    {
        int ud=0;
        int lr=0;
        int n=moves.length();
        for(int i=0;i<n;i++)
        {
            char ch=moves.charAt(i);
            if(ch=='U')
            {
                ud++;
            }
            else if(ch=='D')
            {
                ud--;
            }
            else if(ch=='L')
            {
                lr++;
            }
            else if(ch=='R')
            {
                lr--;
            }
        }
        if(ud==0 && lr==0)
        {
            return true;
        }
        return false;
    }
}
class Solution 
{
    public boolean lemonadeChange(int[] bills) 
    {
        int fivecount=0;
        int tencount=0;

        for(int x: bills)
        {
            if(x==5)
            {
                fivecount++;
            }
            else if(x == 10)
            {
                if(fivecount > 0)
                {
                    fivecount--;
                    tencount++;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                if(fivecount > 0 && tencount >0)
                {
                    fivecount--;
                    tencount--;
                }
                else if(fivecount >=3)
                {
                    fivecount-=3;
                }
                else
                {
                    return false;
                }
            }
        }
        return true;
    }
}
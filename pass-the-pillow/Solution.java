class Solution {
    public int passThePillow(int n, int time)
    {
         int c=2;
        int a=1;
       while(time !=0)
       {
        if(c%2 == 0 && a <= n)
        {
            a++;
            time--;
            if(a == n)
            {
                c++;
            }   
        }
        else if(c%2 != 0 && a > 0)
        {
            a--;
            time--;
            if(a == 1)
            {
                c++;
            }
        }
       }
       return a;
    }
}
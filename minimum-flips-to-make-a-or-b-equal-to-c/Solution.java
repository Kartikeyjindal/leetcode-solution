class Solution 
{
    public int minFlips(int a, int b, int c) 
    {
        int ans=0;
        for(int i=0;i<32;i++)
        {
            int digc=c&1;
            c=c>>1;
            int diga=a&1;
            a=a>>1;
            int digb=b&1;
            b=b>>1;

            if((diga|digb)!=digc)
            {
                if(diga==0 && digb==0 && digc==1)
                {
                    ans++;
                }
                else if(diga==1 && digb==1 && digc==0)
                {
                    ans=ans+2;
                }
                else if(diga==0 && digb==1 && digc==0)
                {
                    ans++;
                }
                else if(diga==1 && digb==0 && digc==0)
                {
                    ans++;
                }
            }
        }
        return ans;
    }
}
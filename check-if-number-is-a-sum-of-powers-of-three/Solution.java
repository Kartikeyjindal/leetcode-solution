class Solution 
{
    public boolean checkPowersOfThree(int n) 
    {
        int maxpow=16;
        int []arr=new int[maxpow];

        for(int i=0;i<maxpow;i++)
        {
            arr[i]=(int)Math.pow(3,i);
        }

        for(int i=maxpow-1;i>=0;i--)
        {
            if(n>=arr[i])
            {
                n-=arr[i];
            }
        }
        if(n == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
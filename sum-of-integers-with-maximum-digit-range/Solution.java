class Solution 
{
    public int maxDigitRange(int[] nums) 
    {
        int maxrange=-1;
        int sum=0;

        for(int num:nums)
        {
            int temp=num;
            int mindig=9;
            int maxdig=0;

            if(temp==0)
            {
                mindig=0;
                maxdig=0;
            }
            while(temp>0)
                {
                    int dig=temp%10;
                    mindig=Math.min(mindig,dig);
                    maxdig=Math.max(maxdig,dig);
                    temp/=10;
                }
            int range=maxdig-mindig;

            if(range>maxrange)
            {
                maxrange=range;
                sum=num;
            }
            else if(range==maxrange)
            {
                sum+=num;
            }
        }
        return sum;
    }
}
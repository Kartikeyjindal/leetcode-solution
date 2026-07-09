class Solution 
{
    public int minOperations(int[] nums) 
    {
        int n=nums.length;
        int countone=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==1)
            {
                countone++;
            }
        }
        if(countone>0)
        {
            return n-countone;
        }
        int minans=Integer.MAX_VALUE;
            int gcdvalue;
            for(int i=0;i<n-1;i++)
            {
                gcdvalue=nums[i];
                int operations=0;
                for(int j=i+1;j<n;j++)
                {
                    operations++;
                    gcdvalue=gcd(gcdvalue,nums[j]);

                    if(gcdvalue==1)
                    {
                        minans= Math.min(minans,operations+n-1);
                        break;
                    }
                }
            }
        return minans==Integer.MAX_VALUE?-1:minans;
    }

    public int gcd(int a,int b)
    {
        while(b!=0)
        {
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}
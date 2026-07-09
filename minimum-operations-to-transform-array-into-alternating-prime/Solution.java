class Solution 
{
    public int minOperations(int[] nums) 
    {
        int n=nums.length;
        int op=0;

        for(int i=0;i<n;i++)
            {
                int val=nums[i];
                if(i%2==0)
                {
                    while(!isprime(val))
                        {
                            val++;
                            op++;
                        }
                }
                else
                {
                    while(isprime(val))
                        {
                            val++;
                            op++;
                        }
                }
            }
        return op;
    }

    public boolean isprime(int val)
    {
        if(val==1)
        {
            return false;
        }
        int count=0;
        for(int i=2;i*i<=val;i++)
            {
                if(val%i==0)
                {
                    return false;
                }
            }
        return true;
    }
}
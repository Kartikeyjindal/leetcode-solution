class Solution 
{
    public int countDigitOccurrences(int[] nums, int digit) 
    {
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++)
            {
                int num=nums[i];
                while(num>0)
                    {
                        int a=num%10;
                        if(a==digit)
                        {
                            ans++;
                        }
                        num=num/10;
                    }
            }
        return ans;
    }
    
}
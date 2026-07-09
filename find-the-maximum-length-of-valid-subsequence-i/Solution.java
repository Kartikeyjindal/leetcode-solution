class Solution 
{
    public int maximumLength(int[] nums) 
    {
        int countodd=0;
        int counteven=0;

        for(int num:nums)
        {
            if(num%2==0)
            {
                counteven++;
            }
            else
            {
                countodd++;
            }
        }
        int parity=nums[0]%2;
        int alt=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]%2 != parity)
            {
                alt++;
                parity=nums[i]%2;
            }
        }
        return Math.max(alt,Math.max(countodd,counteven));
    }
}
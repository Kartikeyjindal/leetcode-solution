class Solution 
{
    public int minPairSum(int[] nums) 
    {
        int sum=0;
        Arrays.sort(nums);
        int n=nums.length-1;
        int s=0;
        while(s<n)
        {
            sum=Math.max(sum,(nums[s]+nums[n]));
            s++;
            n--;
        }
        return sum;
    }
}
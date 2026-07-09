class Solution 
{
    public void sortColors(int[] nums) 
    {
        int n=nums.length;
        int zero=0;
        int two=n-1;
        int l=0;

        while(l<=two)
        {
            if(nums[l]==0)
            {
                int temp=nums[l];
                nums[l]=nums[zero];
                nums[zero]=temp;
                zero++;
                l++;
            }
            else if(nums[l]==2)
            {
                int temp=nums[l];
                nums[l]=nums[two];
                nums[two]=temp;
                two--;
            }
            else
            {
                l++;
            }
        }
    }
}
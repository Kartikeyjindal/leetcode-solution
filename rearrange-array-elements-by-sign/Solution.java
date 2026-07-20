class Solution 
{
    public int[] rearrangeArray(int[] nums) 
    {
        int [] psint=new int[nums.length/2];
        int [] negint=new int[nums.length/2];
        int a=0;
        int b=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                psint[a]=nums[i];
                a++;
            }
            else
            {
                negint[b]=nums[i];
                b++;
            }
        }
        int j=0;
        int p=0,q=0;
        while(j<=a+b && p<nums.length/2 && q<nums.length/2)
        {
            nums[j]=psint[p];
            j++;p++;
            nums[j]=negint[q];
            j++;q++;
        }
        return nums;
    }
}
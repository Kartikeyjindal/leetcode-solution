class Solution 
{
    public void nextPermutation(int[] nums) 
    {
        int n=nums.length;
        int pos=-1;
        // find the point
        for(int i=n-1;i>0;i--)
        {
            if(nums[i-1]<nums[i])
            {
                pos=i-1;
                break;
            }
        }

        if(pos==-1)
        {
            int l=0;
            int r=n-1;
            while(l<r)
            {
                int temp=nums[l];
                nums[l]=nums[r];
                nums[r]=temp;
                l++;
                r--;
            }
        }
        else
        {
            int p=-1;
            // find the next greatest number
            for(int i=pos+1;i<n;i++)
            {
                if(nums[i]>nums[pos])
                {
                    p=i;
                }
            }
            //swap the value
            int temp=nums[pos];
            nums[pos]=nums[p];
            nums[p]=temp;

            //reverse the remaining array

            int l=pos+1;
            int r=n-1;
            while(l<r)
            {
                int t=nums[l];
                nums[l]=nums[r];
                nums[r]=t;
                l++;
                r--;
            }
        }
    }
}
class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int left=nums[0];
        int right=nums[n-1];
        int mid=(left+right)/2;
        for(int i=0;i<n;i++)
        {
            if(target<nums[i])
            {
                right=mid;
            }
            else if(target>nums[i])
            {
                left=mid+1;
            }
            else if(target==nums[i])
            {
                return i;
            }
        }
        return -1;
    }
}
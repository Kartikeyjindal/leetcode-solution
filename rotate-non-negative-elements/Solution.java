class Solution 
{
    public int[] rotateElements(int[] nums, int k) 
    {
        List<Integer> list=new ArrayList<>();
        for(int i:nums)
        {
            if(i>=0)
            {
                list.add(i);
            }
        }
        Collections.rotate(list,-k);
        int a=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>=0)
            {
                nums[i]=list.get(a);
                a++;
            }
        }
        return nums;
    }

}
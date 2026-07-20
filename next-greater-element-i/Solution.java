class Solution 
{
    public int[] nextGreaterElement(int[] nums1, int[] nums2) 
    {
        HashMap<Integer ,Integer> greatermap=new HashMap<>();

        Stack<Integer> stack =new Stack<>();

        for(int num:nums2)
        {
            while(!stack.isEmpty() && num >stack.peek())
            {
                greatermap.put(stack.pop(),num);
            }
            stack.push(num);
        }
        while(!stack.isEmpty())
        {
            greatermap.put(stack.pop(),-1);
        }

        int[] result=new int[nums1.length];

        for(int i=0;i<nums1.length;i++)
        {
            result[i]=greatermap.get(nums1[i]);
        }

        return result;

    }
}
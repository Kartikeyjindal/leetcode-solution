class Solution 
{
    public int[] pivotArray(int[] nums, int pivot) 
    {
        int n=nums.length;
        int []ans=new int[n];

        ArrayList<Integer> small=new ArrayList<>();
        ArrayList<Integer> greater=new ArrayList<>();
        ArrayList<Integer> eq=new ArrayList<>();

        for(int i:nums)
        {
            if(i<pivot)
            {
                small.add(i);
            }
            else if(i==pivot)
            {
                eq.add(i);
            }
            else
            {
                greater.add(i);
            }
        }
        small.addAll(eq);
        small.addAll(greater);

        for(int i=0;i<n;i++)
        {
            ans[i]=small.get(i);
        }
        return ans;
    }
}
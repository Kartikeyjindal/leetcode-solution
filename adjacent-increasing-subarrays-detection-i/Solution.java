class Solution 
{
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) 
    {
        int n=nums.size();
        int prev=0;
        int curr=1;

        for(int i=1;i<n;i++)
        {
            if(nums.get(i-1)<nums.get(i))
            {
                curr++;
            }
            else
            {
                prev=curr;
                curr=1;
            }
            if(curr/2>=k)
            {
                return true;
            }
            if(Math.min(prev,curr)>=k)
            {
                return true;
            }
        }    
        return false;
    }
}

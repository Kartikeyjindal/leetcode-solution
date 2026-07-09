class Solution 
{
    public int scoreDifference(int[] nums) 
    {
        int n=nums.length;
        int pointsa=0;
        int pointsb=0;
        boolean active=false;//0 jabh a 1 jabh b

        for(int i=0;i<n;i++)
        {
            if(nums[i]%2!=0)
            {
                active=!active;
            }
            if(i%6==5)
            {
                active=!active;
            }
            if(active==false)
            {
                pointsa+=nums[i];
            }
            else
            {
                pointsb+=nums[i];
            }
        }
        return pointsa-pointsb;
    }
}
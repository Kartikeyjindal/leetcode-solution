class Solution {
    int[] dp;

    public int jump(int[] nums) 
    {
        int l=0,r=0;
        int n=nums.length;
        int jump=0,farthest;
        while(r<n-1)
        {
            farthest=0;
            for(int i=l;i<=r;i++)
            {
                farthest=Math.max(farthest,i+nums[i]);
            }
            l=r+1;
            r=farthest;
            jump++;
        }
        return jump;
    }
}

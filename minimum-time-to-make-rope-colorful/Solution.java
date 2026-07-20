class Solution
{
    public int minCost(String colors, int[] neededTime) 
    {
        int n=colors.length();
        int time=0;
        int prevmax=0;

        for(int i=0;i<n;i++)
        {
            if(i>0 && colors.charAt(i) != colors.charAt(i-1))
            {
                prevmax=0;
            }
            int curr=neededTime[i];
            time+=Math.min(prevmax,curr);
            prevmax=Math.max(prevmax,curr);
        }
        return time;
    }
}
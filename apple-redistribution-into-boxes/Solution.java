class Solution 
{
    public int minimumBoxes(int[] apple, int[] capacity) 
    {
        Arrays.sort(capacity);
        int totalapple=0;
        for(int i=0;i<apple.length;i++)
        {
            totalapple+=apple[i];
        }
        int ans=0;
        int cap=0;
        for(int i=capacity.length-1;i>=0;i--)
        {
            cap+=capacity[i];
            ans++;
            if(cap>=totalapple)
            {
                return ans;
            }
        }
        return capacity.length;
    }
}
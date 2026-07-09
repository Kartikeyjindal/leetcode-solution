class Solution 
{
    public int garbageCollection(String[] garbage, int[] travel) 
    {
        int n = garbage.length;
        int ans = 0;
        for (String s : garbage)
        {
            ans += s.length();
        }

        int lastM = 0, lastP = 0, lastG = 0;

        for (int i = 0; i < n; i++)
        {
            if (garbage[i].contains("M")) lastM = i;
            if (garbage[i].contains("P")) lastP = i;
            if (garbage[i].contains("G")) lastG = i;
        }

        ans += travelTime(travel, lastM);
        ans += travelTime(travel, lastP);
        ans += travelTime(travel, lastG);

        return ans;
    }

    public int travelTime(int[] travel, int idx)
    {
        int sum = 0;
        for (int i = 0; i < idx; i++)
        {
            sum += travel[i];
        }
        return sum;
    }
}

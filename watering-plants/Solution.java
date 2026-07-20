class Solution 
{
    public int wateringPlants(int[] plants, int capacity) 
    {
        int steps=0;
        int cap=capacity;
        int n=plants.length;
        int i=0;
        while(i < n)
        {
            if(cap<plants[i])
            {
                cap=capacity;
                steps+=i;
                steps+=i;
            }
            else
            {
                cap-=plants[i];
                i++;
                steps++;
            }
        }
        return steps;
    }
}
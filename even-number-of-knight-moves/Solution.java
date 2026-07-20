class Solution 
{
    public boolean canReach(int[] start, int[] target) 
    {
        int startcolor=(start[0]+start[1])%2;
        int endcolor=(target[0]+target[1])%2;

        return startcolor==endcolor;
    }
}
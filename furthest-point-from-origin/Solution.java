class Solution 
{
    public int furthestDistanceFromOrigin(String moves) 
    {
        int left=0;
        int right=0;
        int blank=0;

        for(char ch:moves.toCharArray())
        {
            if(ch=='L')
            {
                left++;
            }
            else if(ch=='R')
            {
                right++;
            }
            else
            {
                blank++;
            }
        }
        if(left>right)
        {
            left+=blank;
            return left-right;
        }
        right+=blank;
        return right-left;
    }
}
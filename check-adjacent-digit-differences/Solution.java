class Solution 
{
    public boolean isAdjacentDiffAtMostTwo(String s) 
    {
        int n=s.length();
        for(int i=0;i<n-1;i++)
            {
                int a=s.charAt(i);
                int b=s.charAt(i+1);
                int diff=Math.abs(a-b);
                if(diff>2)
                {
                    return false;
                }
            }
        return true;
    }
}
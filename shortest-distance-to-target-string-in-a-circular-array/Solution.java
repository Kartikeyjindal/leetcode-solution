class Solution 
{
    public int closestTarget(String[] words, String target, int si) 
    {
        int n=words.length;
        int mindis=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            if(words[i].equals(target))
            {
                int rightdis=Math.abs(i-si);
                int leftdis=Math.abs(n-rightdis);

                int actdis=Math.min(rightdis,leftdis);
                mindis=Math.min(actdis,mindis);
            }
        }
        return mindis==Integer.MAX_VALUE?-1:mindis;
    }
}
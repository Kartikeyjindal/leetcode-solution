class Solution 
{
    public int numberOfSpecialChars(String word) 
    {
        int ans=0;
        Set<Character> set=new HashSet<>();

        for(char ch:word.toCharArray())
        {
            set.add(ch);
        }

        for(char c='a';c<='z';c++)
        {
            if(set.contains(c) && set.contains(Character.toUpperCase(c)))
            {
                ans++;
            }
        }
        return ans;
    }
}
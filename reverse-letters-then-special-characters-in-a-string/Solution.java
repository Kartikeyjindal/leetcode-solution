class Solution
{
    public String reverseByType(String s) 
    {
        StringBuilder letters = new StringBuilder();
        StringBuilder specials = new StringBuilder();

        for (char c : s.toCharArray())
        {
            if (c >= 'a' && c <= 'z')
                letters.append(c);
            else
                specials.append(c);
        }
        letters.reverse();
        specials.reverse();
        StringBuilder ans = new StringBuilder();
        int li = 0, si = 0;

        for (char c : s.toCharArray())
        {
            if (c >= 'a' && c <= 'z')
                ans.append(letters.charAt(li++));
            else
                ans.append(specials.charAt(si++));
        }

        return ans.toString();
    }
}
class Solution 
{
    public boolean halvesAreAlike(String s) 
    {
        Set<Character> vowels=new HashSet<>();
        vowels.add('a'); vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u');
        vowels.add('A'); vowels.add('E'); vowels.add('I'); vowels.add('O'); vowels.add('U');

        int l=s.length();
        int mid=l/2;

        String first=s.substring(0,mid);
        String second=s.substring(mid);

        return count(first,vowels) == count(second,vowels);
    }

    public int count(String s,Set<Character> vowels)
    {
        int count=0;
        for(char c:s.toCharArray())
        {
            if(vowels.contains(c))
            {
                count++;
            }
        }
        return count;
    }
}
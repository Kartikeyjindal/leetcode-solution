class Solution 
{
    public char nextGreatestLetter(char[] letters, char target) 
    {
        char character=letters[0];
        int min=Integer.MAX_VALUE;
        for(char c:letters)
        {
            if(c>target && min>c-target)
            {
                min=c-target;
                character=c;
            }
        }
        return character;
    }
}
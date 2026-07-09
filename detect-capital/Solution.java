class Solution 
{
    public boolean detectCapitalUse(String word) 
    {
        int capcnt = 0;
        for(char ch:word.toCharArray())
        {
            if(Character.isUpperCase(ch))
                capcnt++;
        }
        if(Character.isUpperCase(word.charAt(0)))
        {
            if(capcnt==1)
                return true;
            else if(capcnt==word.length())
                return true;
        }
        else if(capcnt==0)
            return true;
        
        return false;
    }
}
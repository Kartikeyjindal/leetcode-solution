class Solution 
{
    public int characterReplacement(String s, int k) 
    {
        HashMap<Character, Integer> charCount = new HashMap<>();
        int maxCount = 0; 
        int maxLength = 0;
        int left = 0; 

        for (int right = 0; right < s.length(); right++)
        {
            char rightChar = s.charAt(right);
            charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);
            maxCount = Math.max(maxCount, charCount.get(rightChar));
            while ((right - left + 1) - maxCount > k) 
            {
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                if (charCount.get(leftChar) == 0) 
                {
                    charCount.remove(leftChar);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
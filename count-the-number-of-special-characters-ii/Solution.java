import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfSpecialChars(String word) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            
            if (Character.isUpperCase(ch)) {
                if (!map.containsKey(ch)) {
                    map.put(ch, i);
                }
            } else if (Character.isLowerCase(ch)) {
                map.put(ch, i);
            }
        }
        
        for (char ch = 'a'; ch <= 'z'; ch++) {
            char upperCh = Character.toUpperCase(ch);
            
            if (map.containsKey(ch) && map.containsKey(upperCh) && map.get(ch) < map.get(upperCh)) {
                ans++;
            }
        }
        
        return ans;
    }
}
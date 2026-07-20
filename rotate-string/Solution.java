class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        //if lengths are different, false is returned

        s=s+s; // abcde = abcdeabcde
        if(s.contains(goal)) return true;
        return false;
    }
}
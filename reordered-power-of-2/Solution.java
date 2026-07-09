import java.util.*;

class Solution {
    public String stringsort(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public boolean reorderedPowerOf2(int n) {
        String s = stringsort(n);

        for (int i = 0; i < 31; i++) {
            int pow = 1 << i;
            if (s.equals(stringsort(pow))) {
                return true;
            }
        }
        return false;
    }
}

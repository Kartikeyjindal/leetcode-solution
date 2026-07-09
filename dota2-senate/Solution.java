import java.util.*;

class Solution {
    public boolean removeSenator(StringBuilder senate, char ch, int idx) {
        boolean loopAround = false;

        while (true) {
            if (idx == 0) {
                loopAround = true;
            }

            if (senate.charAt(idx) == ch) {
                senate.deleteCharAt(idx);
                break;
            }

            idx = (idx + 1) % senate.length();
        }

        return loopAround;
    }

    public String predictPartyVictory(String senate) {
        StringBuilder senateBuilder = new StringBuilder(senate);
        int R_Count = 0;
        int D_Count = 0;

        for (char c : senateBuilder.toString().toCharArray()) {
            if (c == 'R') {
                R_Count++;
            } else {
                D_Count++;
            }
        }

        int idx = 0;

        while (R_Count > 0 && D_Count > 0) {
            if (senateBuilder.charAt(idx) == 'R') {
                boolean checkRemoval = removeSenator(senateBuilder, 'D', (idx + 1) % senateBuilder.length());
                D_Count--;
                if (checkRemoval) {
                    idx--;
                }
            } else {
                boolean checkRemoval = removeSenator(senateBuilder, 'R', (idx + 1) % senateBuilder.length());
                R_Count--;
                if (checkRemoval) {
                    idx--;
                }
            }

            idx = (idx + 1) % senateBuilder.length();
        }

        return R_Count == 0 ? "Dire" : "Radiant";
    }
}

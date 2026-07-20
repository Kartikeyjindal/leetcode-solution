class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length, count = 0, i = 0;

        for(int j = 0; j < n + k -1; j++){
            if(colors[j % n] == colors[(j + 1) % n]){
                i = j;
            }

            if(j - i + 1 >= k){
                count++;
            }
        }

        return count;
    }
}
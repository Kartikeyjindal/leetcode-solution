import java.util.*;

class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        long ans = nums[0];

        TreeMap<Integer, Integer> ms1 = new TreeMap<>();
        TreeMap<Integer, Integer> ms2 = new TreeMap<>();

        int size1 = 0;
        long curr = nums[0];
        for (int i = 1; i <= 1 + dist; i++) {
            add(ms1, nums[i]);
            size1++;
        }

        while (size1 > k - 1) {
            int x = ms1.lastKey();
            remove(ms1, x);
            size1--;
            add(ms2, x);
        }

        for (Map.Entry<Integer, Integer> e : ms1.entrySet()) {
            curr += (long) e.getKey() * e.getValue();
        }

        ans = curr;

        for (int i = 2; i <= n - 1 - dist; i++) {
            int pre = nums[i - 1];

            if (ms1.containsKey(pre)) {
                remove(ms1, pre);
                size1--;
                curr -= pre;

                int incoming = nums[i + dist];
                if (ms2.isEmpty() || incoming <= ms2.firstKey()) {
                    add(ms1, incoming);
                    size1++;
                    curr += incoming;
                } else {
                    int smallest = ms2.firstKey();
                    remove(ms2, smallest);
                    add(ms1, smallest);
                    size1++;
                    curr += smallest;
                    add(ms2, incoming);
                }
            } else {
                remove(ms2, pre);

                int incoming = nums[i + dist];
                int largest = ms1.lastKey();

                if (incoming <= largest) {
                    remove(ms1, largest);
                    size1--;
                    curr -= largest;
                    add(ms2, largest);
                    add(ms1, incoming);
                    size1++;
                    curr += incoming;
                } else {
                    add(ms2, incoming);
                }
            }

            ans = Math.min(ans, curr);
        }

        return ans;
    }

    private void add(TreeMap<Integer, Integer> map, int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
    }

    private void remove(TreeMap<Integer, Integer> map, int x) {
        int c = map.get(x);
        if (c == 1) map.remove(x);
        else map.put(x, c - 1);
    }
}

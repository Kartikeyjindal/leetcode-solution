class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> s = new HashSet<>();
        List<String> concat = new ArrayList<>();
        Map<String, Boolean> memo = new HashMap<>();

        for (String word : words) {
            s.add(word);
        }
        for (String word : words) {
            if (word.isEmpty()) continue;
            s.remove(word);
            if (checkconcat(word, s, memo)) {
                concat.add(word);
            }
            s.add(word);
        }
        return concat;
    }

    public boolean checkconcat(String word, Set<String> s, Map<String, Boolean> memo) {
        if (memo.containsKey(word)) {
            return memo.get(word);
        }

        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);
            if (s.contains(prefix) && (s.contains(suffix) || checkconcat(suffix, s, memo))) {
                memo.put(word, true);
                return true;
            }
        }
        memo.put(word, false);
        return false;
    }
}

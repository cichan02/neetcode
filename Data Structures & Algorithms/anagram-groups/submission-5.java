class Solution {
    private static final int OFFSET = 97;

        private boolean isAnagrams(String s,  String t) {
            if (s.length() != t.length()) {
                return false;
            }

            int[] letters = new int[26];

            for (int i = 0; i < s.length(); i++) {
                letters[s.charAt(i) - OFFSET]++;
            }

            for (int j = 0; j < t.length(); j++) {
                int k = t.charAt(j) - OFFSET;
                if (letters[k] == 0) {
                    return false;
                }
                letters[k]--;
            }

            return true;
        }

        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = HashMap.newHashMap(strs.length);

            for (String str : strs) {
                boolean isAdded = false;
                for (Map.Entry<String, List<String>> entry: map.entrySet()) {
                    if (isAnagrams(str, entry.getKey())) {
                        entry.getValue().add(str);
                        isAdded = true;
                        break;
                    }
                }
                if (!isAdded) {
                    List<String> list = new ArrayList<>();
                    list.add(str);
                    map.put(str, list);
                }
            }

            return map.values()
                    .stream()
                    .map(List::copyOf)
                    .toList();
        }
}

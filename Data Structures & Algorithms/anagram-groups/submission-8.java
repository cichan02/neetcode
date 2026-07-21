class Solution {
    private static final int OFFSET = 97;

        public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = HashMap.newHashMap(strs.length);
        for (String str : strs) {
            byte[] letters = new byte[26];
            for (int i = 0; i < str.length(); i++) {
                letters[str.charAt(i) - OFFSET]++;
            }
            String key = Arrays.toString(letters);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
        }
}

class Solution {
    // private static final byte OFFSET = 97;
    // private static final byte AMOUNT = 26;
    // private static final char DELIMETER = '#';

        public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = HashMap.newHashMap(strs.length);
        for (String str : strs) {
            byte[] letters = new byte[26];
            for (short i = 0; i < str.length(); i++) {
                letters[str.charAt(i) - 97]++;
            }

            StringBuilder sb = new StringBuilder(26 * 2);
            for (byte f: letters) {
                sb.append(f).append('#');
            }
            String key = sb.toString();
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
        }
}

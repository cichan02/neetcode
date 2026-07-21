class Solution {
    private static final byte OFFSET = 97;
    private static final byte AMOUNT = 26;
    private static final char DELIMETER = '#';

        public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = HashMap.newHashMap(strs.length);
        for (String str : strs) {
            byte[] letters = new byte[AMOUNT];
            for (short i = 0; i < str.length(); i++) {
                letters[str.charAt(i) - OFFSET]++;
            }

            StringBuilder sb = new StringBuilder(AMOUNT * 2);
            for (byte f: letters) {
                sb.append(f).append(DELIMETER);
            }
            String key = sb.toString();
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
        }
}

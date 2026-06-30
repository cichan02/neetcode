class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> grouping = new HashMap<>();
        for (String s: strs) {
            int[]count = new int[26];
            for (char c: s.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            grouping.putIfAbsent(key, new ArrayList<>());
            grouping.get(key).add(s);
        }
     return new ArrayList<>(grouping.values());
    }
}

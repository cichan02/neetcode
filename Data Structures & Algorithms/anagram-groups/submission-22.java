class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> group = HashMap.newHashMap(strs.length);
        for (String s: strs) {
            int[] freq = new int[26];
            for (char c: s.toCharArray()) {
                freq[c - 'a']++;
            }
            String key = Arrays.toString(freq);
            group.putIfAbsent(key, new ArrayList<>());
            group.get(key).add(s);
        }
        return group.values().stream().toList();
    }
}

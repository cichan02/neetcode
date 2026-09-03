class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> grouped = HashMap.newHashMap(strs.length);
        for (String s: strs) {
            int[] freq = new int[26];
            for (char c: s.toCharArray()) {
                freq[c - 'a']++;
            }
            String key = Arrays.toString(freq);
            grouped.putIfAbsent(key, new ArrayList<>());
            grouped.get(key).add(s);
        }
        return grouped.values().stream().toList();
    }
}

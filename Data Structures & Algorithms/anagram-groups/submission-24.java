class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = HashMap.newHashMap(strs.length);
        for (String str: strs) {
            int[] chars  = new int[26];
            for (char c: str.toCharArray()) {
                chars[c - 'a']++;
            }
            String key = Arrays.toString(chars);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(str);
        }
        return res.values().stream().toList();
    }
}

class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] charArray = str.toCharArray();
                Arrays.sort(charArray);
                String key = new String(charArray);
                if (!map.containsKey(key)) {
                    List<String> list = new ArrayList<>();
                    list.add(str);
                     map.put(key, list);
                } else {
                    map.get(key).add(str);
                }
            }
            return new ArrayList<>(map.values());
        }
}

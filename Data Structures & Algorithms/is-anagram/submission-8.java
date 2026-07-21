class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        
        for (char c: t.toCharArray()) {
            Integer count = map.get(c);
            if (count == null) {
                return false;
            }
            count--;
            if (count == 0) {
                map.remove(c);
            } else {
                map.put(c, count);
            }
        }
        
        return map.isEmpty();
    }
}

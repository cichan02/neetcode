class Solution {
    public boolean checkInclusion(String s1, String s2) {
         if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> freq = HashMap.newHashMap(s1.length());
        Map<Character, Integer> window = HashMap.newHashMap(s1.length());
        for (int i = 0; i < s1.length(); i++) {
            freq.put(s1.charAt(i), freq.getOrDefault(s1.charAt(i), 0) + 1);
            window.put(s2.charAt(i), window.getOrDefault(s2.charAt(i), 0) + 1);
        }

        for (int l = 0, r = s1.length(); r < s2.length(); l++, r++) {
            if (freq.equals(window)) {
                return true;
            }

            char rc = s2.charAt(r);
            char lc = s2.charAt(l);
            window.put(rc, window.getOrDefault(rc, 0) + 1);
            window.put(lc, window.get(lc) - 1);
            if (window.get(lc) == 0) {
                window.remove(lc);
            }
        }
        return freq.equals(window);
    }
}

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> freq = HashMap.newHashMap(s1.length());
        for (char c : s1.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int need = freq.size();

        Map<Character, Integer> window = HashMap.newHashMap(s1.length());
        int have = 0;
        for (int l = 0, r = 0; r < s2.length(); r++) {
            char rc = s2.charAt(r);

            if (!freq.containsKey(rc)) {
                continue;
            }

            window.put(rc, window.getOrDefault(rc, 0) + 1);
            if (Objects.equals(freq.get(rc), window.get(rc))) {
                have++;
            }

            while (have == need) {
                if (r - l + 1 == s1.length()) {
                    return true;
                }
                char lc = s2.charAt(l++);
                if (freq.containsKey(lc)) {
                    window.put(lc, window.get(lc) - 1);
                    if (window.get(lc) < freq.get(lc)) {
                        have--;
                    }
                }
            }
        }
        return false;
    }
}

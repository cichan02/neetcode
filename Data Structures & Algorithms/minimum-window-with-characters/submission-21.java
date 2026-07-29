class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty() || t.length() > s.length()) {
            return  "";
        }

        Map<Character, Integer> tFreq = HashMap.newHashMap(t.length());
        for (char c: t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> window = HashMap.newHashMap(tFreq.size());
        int have = 0, need = tFreq.size();
        String res = "";
        for (int l = 0, r = 0; r < s.length(); r++) {
            char rc = s.charAt(r);
            if (!tFreq.containsKey(rc)){
                continue;
            }
            window.put(rc, window.getOrDefault(rc, 0) + 1);
            if (window.get(rc) == tFreq.get(rc)) {
                have++;
            }

            while (have == need) {
                char lc = s.charAt(l);
                if (tFreq.containsKey(lc)) {
                    window.put(lc, window.get(lc) - 1);
                    if (window.get(lc) < tFreq.get(lc)) {
                        have--;
                    }
                }
                if (res.isEmpty() || res.length() > r - l + 1) {
                    res = s.substring(l, r + 1);
                }
                l++;
            }
        }
        return res;
    }
}

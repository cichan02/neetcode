class Solution {
        public String minWindow(String s, String t) {
        if (t.isEmpty()) {
            return "";
        }

        HashMap<Character, Integer> tMap = HashMap.newHashMap(t.length());
        for (char c: t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> window = new HashMap<>();
        int have = 0, need = tMap.size();
        String res = "";

        for (int l = 0, r = 0; r < s.length(); r++) {
            char rc = s.charAt(r);
            if (!tMap.containsKey(rc)) {
                continue;
            }
            window.put(rc, window.getOrDefault(rc, 0) + 1);
            
            if (window.get(rc) == tMap.get(rc)) {
                have++;
            }

            while (have == need) {
                char lc = s.charAt(l);
                if (tMap.containsKey(lc)) {
                    window.put(lc, window.get(lc) - 1);
                    if (window.get(lc) < tMap.get(lc)) {
                        have--;
                    }
                }
                if (res.isEmpty() || r - l + 1 < res.length()) {
                    res = s.substring(l, r + 1);
                }
                l++;
            }
        }

        return res;
        }
}

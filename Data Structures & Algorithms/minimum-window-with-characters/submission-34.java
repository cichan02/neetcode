class Solution {
    public String minWindow(String s, String t) {
        Map<Integer, Integer> tFreq = HashMap.newHashMap(t.length());
        Map<Integer, Integer> window = HashMap.newHashMap(s.length());
        int have = 0;
        String res = "";

        t.chars().forEach(c -> tFreq.merge(c, 1, Integer::sum));

        for (int l = 0, r = 0; r < s.length(); r++) {
            int rc = s.charAt(r);
            window.merge(rc, 1, Integer::sum);
            if (window.get(rc).equals(tFreq.get(rc))) {
                have++;
            }

            while (tFreq.size() == have) {
                if (res.isEmpty() || (r - l + 1) < res.length()) {
                    res = s.substring(l, r + 1);
                }

                int lc = s.charAt(l++);
                if (tFreq.containsKey(lc)) {
                    window.merge(lc, 1, (a, b) -> a - b);
                    if (window.get(lc) < tFreq.get(lc)) {
                        have--;
                    }
                }
            }
        }

        return res;
    }
}

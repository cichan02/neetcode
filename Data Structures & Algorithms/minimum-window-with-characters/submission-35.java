class Solution {
    public String minWindow(String s, String t) {
        Map<Integer, Integer> freq = HashMap.newHashMap(t.length());
        t.chars().forEach(i -> freq.merge(i, 1, Integer::sum));

        int have = 0;
        Map<Integer, Integer> window = HashMap.newHashMap(s.length());
        String res = "";
        for (int l = 0, r = 0; r < s.length(); r++) {
            int rc = s.charAt(r);
            window.merge(rc, 1, Integer::sum);
            if (Objects.equals(window.get(rc), freq.get(rc))) {
                have++;
            }

            while (freq.size() == have) {
                if (r - l + 1 < res.length() || res.isEmpty()) {
                    res = s.substring(l, r+1);
                }

                int lc = s.charAt(l++);
                window.merge(lc, -1, Integer::sum);
                if (freq.containsKey(lc) && window.get(lc) < freq.get(lc)) {
                    have--;
                }
            }
        }
        return res;
    }
}

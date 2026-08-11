class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freq = HashMap.newHashMap(s.length());
        int res = 0;
        for (int r = 0, l = 0, maxF = 0; r < s.length(); r++) {
            char rc = s.charAt(r);
            freq.put(rc, freq.getOrDefault(rc, 0) + 1);
            maxF = Math.max(maxF, freq.get(rc));

            while (r - l + 1 - maxF > k) {
                char lc = s.charAt(l++);
                freq.put(lc, freq.get(lc) - 1);
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}

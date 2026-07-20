class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freq = HashMap.newHashMap(s.length());
        int l = 0, maxf = 0, res = 0;
        for (int r = 0; r < s.length(); r++) {
            char rc = s.charAt(r);
            freq.put(rc, freq.getOrDefault(rc, 0) + 1);
            maxf = Math.max(maxf, freq.get(rc));
            while ((r - l + 1) - maxf > k) {
                char lc = s.charAt(l++);
                freq.put(lc, freq.get(lc) - 1);
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}

class Solution {
    public int characterReplacement(String s, int k) {
        Map<Integer, Integer> freq = HashMap.newHashMap(s.length());
        int maxL = 0;
        for (int l = 0, r = 0, maxF = 0; r < s.length(); r++) {
            int rc = s.charAt(r);
            freq.merge(rc, 1, Integer::sum);
            maxF = Math.max(maxF, freq.get(rc));

            while (r-l+1 - maxF > k) {
                int lc = s.charAt(l++);
                freq.merge(lc, -1, Integer::sum);
            }

            maxL = Math.max(maxL, r - l + 1);
        }
        return maxL;
    }
}

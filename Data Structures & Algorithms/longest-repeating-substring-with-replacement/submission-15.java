class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freq = HashMap.newHashMap(s.length());
        int maxL = 0, maxF = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            char rc = s.charAt(r);
            freq.merge(rc, 1, Integer::sum );
            maxF = Math.max(maxF, freq.get(rc));

            while ((r - l + 1) - maxF > k) {
                char lc = s.charAt(l++);
                freq.put(lc, freq.get(lc) - 1);
            }

             maxL = Math.max(maxL, r - l + 1);
        }
        return maxL;
    }
}

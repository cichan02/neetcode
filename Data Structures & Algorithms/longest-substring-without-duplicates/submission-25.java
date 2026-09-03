class Solution {
    public int lengthOfLongestSubstring(final String s) {
        Map<Character, Integer> charToIdx = HashMap.newHashMap(s.length());
        int maxL = 0;

        for (int l = 0, r = 0; r < s.length(); r++) {
            char rc = s.charAt(r);

            if (charToIdx.containsKey(rc)) {
                l = Math.max(l, charToIdx.get(rc) + 1);
            }

            charToIdx.put(rc, r);
            maxL = Math.max(maxL, r - l + 1);
        }

        return maxL;
    }
}

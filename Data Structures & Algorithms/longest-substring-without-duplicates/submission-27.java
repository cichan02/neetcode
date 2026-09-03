class Solution {
    public int lengthOfLongestSubstring(final String s) {
        final Map<Character, Integer> charToIdx = HashMap.newHashMap(s.length());
        int maxL = 0;

        for (int l = 0, r = 0; r < s.length(); r++) {
            l = Math.max(l, charToIdx.getOrDefault(s.charAt(r), l-1) + 1);

            charToIdx.put(s.charAt(r), r);
            maxL = Math.max(maxL, r - l + 1);
        }

        return maxL;
    }
}

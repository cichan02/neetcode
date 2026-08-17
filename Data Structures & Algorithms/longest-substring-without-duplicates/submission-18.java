class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charToIndex = HashMap.newHashMap(s.length());
        int maxL = 0;
        for (int l = -1, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            if (charToIndex.containsKey(c)) {
                l = Math.max(l, charToIndex.get(c));
            }

            maxL = Math.max(maxL, r - l);
            charToIndex.put(c, r);
        }
        return maxL;
    }
}

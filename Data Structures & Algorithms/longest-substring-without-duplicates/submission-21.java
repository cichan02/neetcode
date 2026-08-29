class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charToIndex = HashMap.newHashMap(s.length());
        int maxL = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            char rc = s.charAt(r);
            if (charToIndex.containsKey(rc)) {
                l = Math.max(l, charToIndex.get(rc) + 1);
            }
            charToIndex.put(rc, r);
            maxL = Math.max(maxL, r - l + 1);
        }
        return maxL;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxL = 0;
        Map<Character, Integer> charPos = new HashMap<>();
        for (int r = 0, l = 0; r < s.length(); r++) {
            char rc = s.charAt(r);

            if (charPos.containsKey(rc)) {
                l = Math.max(charPos.get(rc) + 1, l);
            }
            
            charPos.put(rc, r);
            maxL = Math.max(maxL, r - l + 1);
        }
        return maxL;
    }
}

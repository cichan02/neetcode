class Solution {
    public int lengthOfLongestSubstring(String s) {
        // two pointers
        // go right pointer till meet repeat char or till the end
        // then go left pointer till char throw out
        // don't forget to measure last interval
        int l= 0, r = 0, maxL = 0;
        Map<Character, Integer> charToIndex = new HashMap<>();
        while (r < s.length()) {
            char c = s.charAt(r);
            if (charToIndex.containsKey(c)) {
                maxL = Math.max(maxL, r - l);
                l = Math.max(l, charToIndex.remove(c) + 1);
            }
            charToIndex.put(c, r);
            r++;
        }
        return Math.max(maxL, r - l);
    }
}

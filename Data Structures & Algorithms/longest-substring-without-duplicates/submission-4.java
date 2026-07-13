class Solution {
    public int lengthOfLongestSubstring(String s) {
        // two pointers
        // go right pointer till meet repeat char or till the end
        // then go left pointer till char throw out
        // don't forget to measure last interval
        int l= 0, r = 0, maxL = 0;
        Set<Character> meetChar = HashSet.newHashSet(s.length());
        while (r < s.length()) {
            char c = s.charAt(r);
            if (meetChar.contains(c)) {
                maxL = Math.max(maxL, r - l);
                while (meetChar.contains(c) && l <= r) {
                    meetChar.remove(s.charAt(l));
                    l++;
                }
            } else {
                meetChar.add(c);
                r++;
            }
        }
        return Math.max(maxL, r - l);
    }
}

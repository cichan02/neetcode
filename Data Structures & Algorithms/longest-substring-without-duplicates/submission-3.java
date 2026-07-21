class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, left = 0, right = 0;
        Map<Character, Integer> charsToIndex = new HashMap<>();

        while (right < s.length()) {
            if (charsToIndex.containsKey(s.charAt(right))) {
                max = Math.max(max, right - left);
                left = Math.max(charsToIndex.remove(s.charAt(right)) + 1, left);
            } else {
                charsToIndex.put(s.charAt(right), right);
                right++;
            }
        }

        return Math.max(max, right - left);
    }
}

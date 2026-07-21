class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, left = 0, right = 0;
        Set<Character> uniqueChars = new HashSet<>();

        while (right < s.length()) {
            if (uniqueChars.contains(s.charAt(right))) {
                max = Math.max(max, right - left);
                while (uniqueChars.contains(s.charAt(right))) {
                    uniqueChars.remove(s.charAt(left));
                    left++;
                }
            } else {
                uniqueChars.add(s.charAt(right));
                right++;
            }
        }

        return Math.max(max, right - left);
    }
}

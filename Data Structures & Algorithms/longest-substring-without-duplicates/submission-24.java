class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Integer, Integer> indices = HashMap.newHashMap(s.length());
        int maxL = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            int rc = s.charAt(r);
            if (indices.containsKey(rc)) {
                l = Math.max(l, indices.get(rc) + 1);
            }
            indices.put(rc, r);
            maxL = Math.max(maxL, r - l + 1);
        }
        return maxL;
    }
}

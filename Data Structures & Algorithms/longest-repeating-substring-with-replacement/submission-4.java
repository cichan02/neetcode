class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        int l = 0, res = 0, maxf = 0;
        for (int r = 0; r < s.length(); r++) {
            int f = freq.getOrDefault(s.charAt(r), 0) + 1;
            maxf = Math.max(maxf, f);
            freq.put(s.charAt(r), f);
            while ((r - l + 1) - maxf > k) {
                freq.put(s.charAt(l), freq.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}

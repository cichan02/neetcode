class Solution {
    private static final int OFFSET = 97;

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] set = new int[26];

        for (int i = 0; i < s.length(); i++) {
            set[s.charAt(i)  - OFFSET ]++;
        }

        for (int j = 0; j < t.length(); j++) {
            int k = t.charAt(j) -  OFFSET;
            if (set[k] == 0) {
                return false;
            }
            set[k]--;
        }

        return true;
    }
}

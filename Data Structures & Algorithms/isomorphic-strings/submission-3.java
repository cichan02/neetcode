class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> st = HashMap.newHashMap(s.length());
        Map<Character, Character> ts = HashMap.newHashMap(s.length());

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if ((st.containsKey(sc) && st.get(sc) != tc) || (ts.containsKey(tc) && ts.get(tc) != sc)) {
                return false;
            }

            st.put(sc, tc);
            ts.put(tc, sc);
        }
        return true;
    }
}
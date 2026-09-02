class Solution {
    public boolean isIsomorphic(String s, String t) {
        final int len = s.length();

        if (len != t.length()) return false;

        final Map<Character, Character> st = HashMap.newHashMap(len);
        final Map<Character, Character> ts = HashMap.newHashMap(len);

        for (int i = 0; i < len; i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if ((st.containsKey(sc) && st.get(sc) != tc) || (ts.containsKey(tc) && ts.get(tc) != sc)) {
                return false;
            }

            st.put(sc, tc);
            ts.put(tc, sc);
        }

        st.clear();
        ts.clear();

        return true;
    }
}
class Solution {
    public String longestPalindrome(String s) {
        String t = unify(s);

        int[] p = oddManacher(t);

        return subseq(s, p);
    }

    private String unify(String s) {
        char del = '#';
        StringBuilder sb = new StringBuilder();
        sb.append(del);
        for(char c: s.toCharArray()) {
            sb.append(c)
                .append(del);
        }
        return sb.toString();
    }

    private int[] oddManacher(String s) {
        final int len = s.length();
        final int[] p = new int[len];
        for (int i = 0; i < len; i++) {
            p[i] = 1;
            while (i - p[i] >= 0 && i + p[i] < len && s.charAt(i - p[i]) == s.charAt(i + p[i])) {
                p[i]++;
            }
        }
        return p;
    }

    private String subseq(String s, int[] p) {
        int center = 0, len = 1;
        for (int i = 0; i < p.length; i++) {
            if (p[i] > len) {
                len = p[i];
                center = i;
            }
        }
        int start = (center - len + 1) / 2;
        return s.substring(start, start + len - 1);
    }
}

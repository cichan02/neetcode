class Solution {
    public String longestPalindrome(String s) {
        String t = unify(s);

        int[] p = oddManacher(t);

        return subseq(s, p);
    }

    private String unify(String s) {
        final char del = '#';
        StringBuilder sb = new StringBuilder()
            .append(del);
        for (char c: s.toCharArray()) {
            sb.append(c).append(del);
        }
        return sb.toString();
    }

    private int[] oddManacher(String s) {
        int len = s.length();
        int[] p = new int[len];
        for (int l = 0, r = -1, i = 0; i < len; i++) {
            p[i] = i > r ? 1 : Math.min(p[l + r - i], r - i + 1);
            while (i - p[i] >= 0 && i + p[i] < len && s.charAt(i - p[i]) == s.charAt(i + p[i])) {
                p[i]++;
            }
            if (i + p[i] > r) {
                r = i + p[i] - 1;
                l = i - p[i] + 1;
            }
        }
        return p;
    }

    private String subseq(String s, int[] p) {
        int center = 0, len = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] > len) {
                len = p[i];
                center = i;
            }
        }
        int begin = (center - len + 1) / 2;
        return s.substring(begin, begin + len - 1);
    }
}

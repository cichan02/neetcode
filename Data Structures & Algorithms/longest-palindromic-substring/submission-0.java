public class Solution {
    public String longestPalindrome(String s) {
        String t = unify(s);
        
        int[] p = oddManacher(t);

        return concat(s, p);
    }

    private String unify(final String s) {
        final char delimiter = '#';
        final StringBuilder sb = new StringBuilder().append(delimiter);
        for (char c: s.toCharArray()) {
            sb.append(c).append(delimiter);
        }
        return sb.toString();
    }

    private int[] oddManacher(final String s) {
        final int len = s.length();
        final int[] p = new int[len];
        for (int l = 0, r = 0, i = 0; i < len; i++) {
            p[i] = i > r ? 0 : Math.min(p[l+r-i], r-i);
            while (i - p[i] - 1>= 0 && i + p[i] + 1< len && s.charAt(i-p[i]-1) == s.charAt(i+p[i]+1)) {
                p[i]++;
            }
            if (i + p[i] > r) {
                r = i + p[i];
                l = i - p[i];
            }
        }
        return p;
    }

    private String concat(final String s, final int[] p) {
        int resLen = 0, center_i = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] > resLen) {
                resLen = p[i];
                center_i = i;
            }
        }
        int resIdx = (center_i - resLen) / 2;
        return s.substring(resIdx, resIdx + resLen);
    }
}
class Solution {
    public String longestPalindrome(String s) {
        byte[] t = unify(s.getBytes());

        int[] p = manacherOdd(t);

        return concat(s, p);
    }

    private byte[] unify(final byte[] s) {
        final byte delimiter = '#';
        final byte[] t = new byte[s.length * 2 + 1];
        t[0] = delimiter;
        for (int i = 0; i < s.length; i++) {
            t[2*i + 1] = s[i];
            t[2*i + 2] = delimiter;
        }
        return t;
    }

    private int[] manacherOdd(final byte[] s) {
        final int len = s.length;
        final int[] p = new int[len];
        for (int l = 0, r = 0, i = 0; i < len; i++) {
            p[i] = i > r ? 1 : Math.min(p[l + r - i], r - i + 1);
            while (i - p[i] >= 0 && i +  p[i] < len && s[i - p[i]] == s[i + p[i]]) {
                p[i]++;
            }
            if (i + p[i] - 1 > r) {
                r = i + p[i] - 1;
                l = i - p[i] + 1;
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
        int resIdx = (center_i - resLen + 1) / 2;
        return s.substring(resIdx, resIdx + resLen - 1);
    }
}
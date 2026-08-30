class Solution {
    public String longestPalindrome(String s) {
        CharSequence t = unify(s);

        int[] p = oddManacher(t);

        return subSeq(s, p).toString();
    }

    private CharSequence unify(final CharSequence s) {
        final char delimiter = '#';
        final char[] t = new char[s.length() * 2 + 1];
        t[0] = delimiter;
        for (int i = 0; i < s.length(); i++) {
            t[i*2 + 1] = s.charAt(i);
            t[i*2 + 2] = delimiter;
        }
        return new String(t).intern();
    }

    private int[] oddManacher(final CharSequence s) {
        final int len = s.length();
        final int[] p = new int[len];
        for (int l = 0, r = 0, i = 0; i < len; i++) {
            p[i] = i > r ? 1 : Math.min(p[l+r-i], r-i+1);
            while (i - p[i] >= 0 && i + p[i] < len && s.charAt(i - p[i]) == s.charAt(i + p[i])) {
                p[i]++;
            }
            if (i + p[i] - 1 > r) {
                r = i + p[i] - 1;
                l = i - p[i] + 1;
            }
        }
        return p;
    }

    private CharSequence subSeq(final CharSequence s, final int[] p) {
        int resLen = 0, center_i = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] > resLen) {
                resLen = p[i];
                center_i = i;
            }
        }
        int resIdx = (center_i - resLen + 1) / 2;
        return s.subSequence(resIdx, resIdx + resLen - 1);
    }
 }

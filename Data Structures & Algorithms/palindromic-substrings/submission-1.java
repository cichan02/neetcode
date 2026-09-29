class Solution {
    // sum odd and even Manacher
    public int countSubstrings(String s) {
        int[] odd = oddManacher(s);

        int[] even = evenManacher(s);

        return sum(odd, even);
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

    private int[] evenManacher(String s) {
        int len = s.length();
        int[] p = new int[len];
        for (int l = 0, r = -1, i = 0; i < len; i++) {
            p[i] = i > r ? 0 : Math.min(p[l + r - i + 1], r - i + 1);
            while (i - p[i] - 1 >= 0 && i + p[i] < len && s.charAt(i - p[i] - 1) == s.charAt(i + p[i])) {
                p[i]++;
            }
            if (i + p[i] > r) {
                r = i + p[i] - 1;
                l = i - p[i];
            }
        }
        return p;
    }

    private int sum(int[] p, int[] q) {
        return IntStream.concat(IntStream.of(p), IntStream.of(q)).sum();
    }
}

class Solution {
    public int minimumRecolors(String blocks, int k) {
        int freqW = 0, l = 0, res = Integer.MAX_VALUE;
        for (int r = 0; r < blocks.length(); r++) {
            char rc = blocks.charAt(r);
            if (rc == 'W') {
                freqW++;
            }

            while (r - l + 1 > k) {
                char lc = blocks.charAt(l++);
                if (lc == 'W') {
                    freqW--;
                }
                res = Math.min(res, freqW);
            }
        }
        return Math.min(res, freqW);
    }
}
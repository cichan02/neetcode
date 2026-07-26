class Solution {
    public int minimumRecolors(String blocks, int k) {
        int wFreq = 0, res = Integer.MAX_VALUE;
        for (int l = 0, r = 0; r < blocks.length(); r++) {
            char rc = blocks.charAt(r);
            if (rc == 'W') {
                wFreq++;
            }


            while (r - l + 1 > k) {
                char lc = blocks.charAt(l++);
                if (lc == 'W') {
                    wFreq--;
                }
                res = Math.min(res, wFreq);
            }
        }
        return Math.min(res, wFreq);
    }
}
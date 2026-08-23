// Inside static (size of sliding window = k) count number of 'W' blocks
// On each turn of sliding recound minimum

// 1) check basic success
// 2) if all blocks are 'B'?
// 3) all blocks are 'W'?
// 4) length of blocks = k;

class Solution {
    public int minimumRecolors(String blocks, int k) {
        int countW = 0;

        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                countW++;
            }
        }

        int minR = countW;

        for (int l = 0, r = k; r < blocks.length(); r++, l++) {
            if (blocks.charAt(l) == 'W') {
                countW--;
            }

            if (blocks.charAt(r) == 'W') {
                countW++;
            }

            minR = Math.min(minR, countW);
        }

        return minR;
    }
}
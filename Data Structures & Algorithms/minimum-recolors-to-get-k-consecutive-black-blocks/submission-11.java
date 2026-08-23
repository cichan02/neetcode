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

        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i - k) == 'W') {
                countW--;
            }

            if (blocks.charAt(i) == 'W') {
                countW++;
            }

            minR = Math.min(minR, countW);
        }

        return minR;
    }
}
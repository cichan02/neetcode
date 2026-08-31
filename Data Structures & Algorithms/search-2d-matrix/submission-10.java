public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int cols = matrix[0].length;

        int l = 0, r = matrix.length * cols - 1;
        while (l <= r) {
            int m = (l + r) >>> 1;
            int row = m / cols, col = m % cols;
            if (target < matrix[row][col]) {
                r = m - 1;
            } else if (target > matrix[row][col]) {
               l = m + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
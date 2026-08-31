class Solution {
    private int rows;
    private int cols;

    public boolean searchMatrix(int[][] matrix, int target) {
        this.rows = matrix.length;
        this.cols = matrix[0].length;

        int t = 0, b = rows - 1;
        while (t <= b) {
            int m = (t + b) >>> 1;
            if (target < matrix[m][0]) {
                b = m - 1;
            } else if (target > matrix[m][cols - 1]) {
                t = m + 1;
            } else {
                break;
            }
        }

        if (t > b) {
            return false;
        }

        int row = (t + b) / 2, l = 0, r = cols - 1;
        while (l <= r) {
            int m = (l + r) >>> 1;
            if (target == matrix[row][m]) {
                return true;
            }

            if (target < matrix[row][m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
}

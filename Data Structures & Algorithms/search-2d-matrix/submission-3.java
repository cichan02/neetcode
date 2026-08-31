class Solution {
    private int rows;
    private int cols;

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            int val = matrix[row][col];
            if (target == val) {
                return true;
            } else if (target < val) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}

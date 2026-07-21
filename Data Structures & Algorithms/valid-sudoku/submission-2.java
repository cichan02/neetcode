class Solution {
    private static final char EMPTY = '.';
    private static final byte SUDOKU_SIZE = 9;

    public boolean isValidSudoku(char[][] board) {
         boolean[][] matrix = new boolean[SUDOKU_SIZE][3 * SUDOKU_SIZE];
        for (int i = 0; i < SUDOKU_SIZE; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == EMPTY) {
                    continue;
                }

                int number = board[i][j] - '1';

                if (matrix[number][i]) {
                    return false;
                }
                matrix[number][i] = true;

                if (matrix[number][j+SUDOKU_SIZE]) {
                    return false;
                }
                matrix[number][j+SUDOKU_SIZE] = true;

                int k = i / 3 + (j / 3) * 3 + 2 * SUDOKU_SIZE;
                if (matrix[number][k]) {
                    return false;
                }
                matrix[number][k] = true;
            }
        }
        return true;
    }
}

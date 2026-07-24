class Solution {
    private static int ROWS;
    private static int COLS;

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (backtrack(board, i, j, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int i, int j, String word) {
        if (word.isEmpty()) {
            return true;
        }

        if (i < 0 || i >= ROWS || j < 0 || j >= COLS || board[i][j] == ' ' || board[i][j] != word.charAt(0)) {
            return false;
        }

        board[i][j] = ' ';
        boolean res = backtrack(board, i + 1, j, word.substring(1)) ||
                             backtrack(board, i - 1, j, word.substring(1)) ||
                            backtrack(board, i, j + 1, word.substring(1)) ||
                            backtrack(board, i, j - 1, word.substring(1));
        board[i][j] = word.charAt(0);
        return res;
    }
}

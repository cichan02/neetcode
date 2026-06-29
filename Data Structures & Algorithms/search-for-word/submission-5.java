class Solution {
    private static int COLS;
    private static int ROWS;

    public boolean exist(char[][] board, String word) {
        COLS = board.length;
        ROWS = board[0].length;

        for (int i = 0; i < COLS; i++) {
            for (int j = 0; j < ROWS; j++) {
                if (backtrack(board, i, j, "", word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, int i, int j, String curr, String word) {
        if (word.isEmpty()) {
            return true;
        }

        if (i < 0 || i >= COLS || j <  0 || j >= ROWS || board[i][j] != word.charAt(0) || board[i][j] ==  ' ') {
             return false;
        }

        board[i][j] = ' ';
        char temp = word.charAt(0);
        boolean res = backtrack(board, i + 1, j, curr + temp, word.substring(1)) ||
                                    backtrack(board, i - 1, j, curr + temp, word.substring(1)) ||
                                    backtrack(board, i, j + 1, curr + temp, word.substring(1)) ||
                                    backtrack(board, i, j - 1, curr + temp, word.substring(1));
        board[i][j] = temp;
        return res;
    }
}

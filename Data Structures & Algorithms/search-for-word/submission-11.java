class Solution {
    private int rows;
    private int cols;

    public boolean exist(char[][] board, String word) {
        this.rows = board.length;
        this.cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (search(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, int i, int j, String word, int cur) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || word.charAt(cur) != board[i][j]) {
            return false;
        }

        if (cur + 1 == word.length()) {
            return true;
        }

        char tmp = board[i][j];
        board[i][j] = ' ';
        boolean res = search(board, i + 1, j, word, cur + 1)
            || search(board, i - 1, j, word, cur + 1)
            || search(board, i, j + 1, word, cur + 1)
            || search(board, i, j - 1, word, cur + 1);
        board[i][j] = tmp;
        return res;
    }
}

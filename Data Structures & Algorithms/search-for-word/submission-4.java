class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
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

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(0)) {
            return false;
        }

        board[i][j] = ' ';
        char tmp = word.charAt(0);
        boolean res =  backtrack(board, i - 1, j, curr + tmp, word.substring(1)) ||
                backtrack(board, i + 1, j, curr + tmp, word.substring(1)) ||
                backtrack(board, i, j - 1, curr + tmp, word.substring(1)) ||
                backtrack(board, i, j + 1, curr + tmp, word.substring(1));
        board[i][j] = tmp;
        return res;
    }
}

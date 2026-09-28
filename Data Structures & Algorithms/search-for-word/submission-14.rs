impl Solution {
    pub fn exist(mut board: Vec<Vec<char>>, word: String) -> bool {
        let word: Vec<char> = word.chars().collect();

        for i in 0..board.len() {
            for j in 0..board[0].len() {
                if Self::search(&mut board, i, j, &word, 0) {
                    return true;
                }
            }
        }

        false
    }

    fn search(board: &mut Vec<Vec<char>>, i: usize, j: usize, word: &Vec<char>, cur: usize) -> bool {
        if i >= board.len() || j >= board[0].len() || board[i][j] == ' ' || board[i][j] != word[cur] {
            return false;
        }

        if cur + 1 == word.len() {
            return true;
        }

        let tmp: char = board[i][j];
        board[i][j] = ' ';
        let res: bool = Self::search(board, i + 1, j, word, cur + 1)
            || Self::search(board, i - 1, j, word, cur + 1)
            || Self::search(board, i, j + 1, word, cur + 1)
            || Self::search(board, i, j - 1, word, cur + 1);
        board[i][j] = tmp;
        return res;
    }
}

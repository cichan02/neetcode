impl Solution {
    pub fn exist(mut board: Vec<Vec<char>>, word: String) -> bool {
        let word: Vec<char> = word.chars().collect();

        for i in 0..board.len() {
            for j in 0..board[0].len() {
                if Self::search(&mut board, i as i32, j as i32, &word, 0) {
                    return true;
                }
            }
        }

        false
    }

    fn search(board: &mut Vec<Vec<char>>, i: i32, j: i32, word: &Vec<char>, cur: usize) -> bool {
        if i < 0 || i >= board.len() as i32 || j < 0 || j >= board[0].len() as i32
            || board[i as usize][j as usize] == ' ' || board[i as usize][j as usize] != word[cur]
        {
            return false;
        }

        if cur + 1 == word.len() {
            return true;
        }

        let tmp: char = board[i as usize][j as usize];
        board[i as usize][j as usize] = ' ';
        let res: bool = Self::search(board, i + 1, j, word, cur + 1)
            || Self::search(board, i - 1, j, word, cur + 1)
            || Self::search(board, i, j + 1, word, cur + 1)
            || Self::search(board, i, j - 1, word, cur + 1);
        board[i as usize][j as usize] = tmp;
        return res;
    }
}

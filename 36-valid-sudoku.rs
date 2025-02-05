use std::collections::HashSet;
impl Solution {
    pub fn is_sector_valid(x: usize, y: usize, board: &Vec<Vec<char>>) -> bool {
        let mut chars = HashSet::new();
        let mut count = 0;
        (0..3).for_each(|sx| (0..3).for_each(|sy| {
            let xi=3*x+sx;
            let yi=3*y+sy;
            let c = board[xi][yi];
            if c != '.' {
                chars.insert(c);
                count = count + 1;
            }
        }));
        return chars.len() == count;
    }

    pub fn is_row_valid(y: usize, board: &Vec<Vec<char>>) -> bool {
        let mut chars = HashSet::new();
        let mut count = 0;
        (0..9).for_each(|sx| {
            let c = board[sx][y];
            if c != '.' {
                chars.insert(c);
                count = count + 1;
            }
        });
        return chars.len() == count;
    }

    pub fn is_col_valid(x: usize, board: &Vec<Vec<char>>) -> bool {
        let mut chars = HashSet::new();
        let mut count = 0;
        (0..9).for_each(|sy| {
            let c = board[x][sy];
            if c != '.' {
                chars.insert(c);
                count = count + 1;
            }
        });
        return chars.len() == count;
    }

    pub fn is_valid_sudoku(board: Vec<Vec<char>>) -> bool {
        return (0..9).all(|i| Self::is_col_valid(i, &board))
            && (0..9).all(|i| Self::is_row_valid(i, &board))
            && (0..3).all(|x| (0..3).all(|y| Self::is_sector_valid(x,y, &board)))
    }
}

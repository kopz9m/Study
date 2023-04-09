package LeetCode;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author: Patrick
 * @Date: 2023-03-31-17:00
 * @Description:
 */
public class _36_ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[][] square = new HashSet[3][3];

        for (int i = 0; i < cols.length; i++) {
            cols[i] = new HashSet<>();
        }
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new HashSet<>();
        }

        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                square[i][j] = new HashSet<>();
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char x = board[i][j];
                if (x == '.'){
                    continue;
                }
                if (rows[i].contains(x)) {
                    return false;
                } else {
                    rows[i].add(x);
                }
                if (cols[j].contains(x)) {
                    return false;
                } else {
                    cols[j].add(x);
                }
                if (square[i / 3][j / 3].contains(x)) {
                    return false;
                } else {
                    square[i / 3][j / 3].add(x);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        _36_ValidSudoku solution = new _36_ValidSudoku();
        boolean isValid = solution.isValidSudoku(board);
        System.out.println(isValid);
    }
}

package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Patrick
 * @Date: 2023-03-21-15:17
 * @Description:
 */
public class _130_SurroundedRegions {
    public void solve(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                boolean[][] area = new boolean[board.length][board[0].length];
                if (board[i][j] == 'O' ) {
                    if (dfs(board, visited, area, i, j)) {
                        // update o to x
                        for (int k = 0; k < area.length; k++) {
                            for (int l = 0; l < area[0].length; l++) {
                                if (area[k][l]){
                                    board[k][l] = 'X';
                                }
                            }

                        }
                    }
                    ;
                }

            }
        }


    }

    private boolean dfs(char[][] board, boolean[][] visited, boolean[][] area, int i, int j) {
        if (visited[i][j]){
            return true;
        }
        visited[i][j] = true;
        if (board[i][j] == 'O') {
            // if reach edge ,return false
            if (i == 0 || i == board.length-1 || j == 0 || j == board[0].length - 1) {
                return false;
            }
            area[i][j] = true;
            return dfs(board, visited, area, i - 1, j)
                    && dfs(board, visited, area, i + 1, j)
                    && dfs(board, visited, area, i, j - 1)
                    && dfs(board, visited, area, i, j + 1);
        } else {
            // if X,return true
            return true;
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}};
        _130_SurroundedRegions surroundedRegions = new _130_SurroundedRegions();
        surroundedRegions.solve(board);
        System.out.println(board);
    }
}

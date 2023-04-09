package LeetCode;

import java.util.Arrays;

/**
 * @Author: Patrick
 * @Date: 2023-03-20-14:29
 * @Description:
 */
public class _79_WordSearch {
    public boolean exist(char[][] board, String word) {

        if (board.length == 0) {
            return false;
        }

        if (board[0].length == 0) {
            return false;
        }

        String preMove = "";


        int width = board[0].length;
        int height = board.length;
        boolean[][] visited = new boolean[height][width];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, word, visited,  i, j, 0)) {
                    return true;
                }

            }
        }

        return false;

    }

    private boolean dfs(char[][] board, String word, boolean[][] visited, int row, int col, int index) {
        if (word.length() == index) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }
        visited[row][col] = true;
        boolean exist = dfs(board, word, visited, row, col + 1, index + 1) ||
                dfs(board, word, visited, row + 1, col, index + 1) ||
                dfs(board, word, visited, row, col - 1, index + 1) ||
                dfs(board, word, visited, row - 1, col, index + 1);
        visited[row][col] = false;
        return exist;
    }

}

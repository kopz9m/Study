package LeetCode;

/**
 * @Author: Patrick
 * @Date: 2023-03-21-14:30
 * @Description:
 */
public class _200_NumberOfIslands {
    public int numIslands(char[][] grid) {

        int ans = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    ans++;
                }

            }
        }
        return ans;

    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        if (grid[i][j] == '1') {
            if (i > 0 && !visited[i - 1][j]) {
                dfs(grid, visited, i - 1, j);
            }
            if (i < grid.length - 1 && !visited[i + 1][j]) {
                dfs(grid, visited, i + 1, j);
            }
            if (j > 0 && !visited[i][j - 1]) {
                dfs(grid, visited, i, j - 1);
            }
            if (j < grid[0].length - 1 && !visited[i][j + 1]) {
                dfs(grid, visited, i, j + 1);
            }

        }


    }

    public static void main(String[] args) {
        _200_NumberOfIslands test = new _200_NumberOfIslands();
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        test.numIslands(grid);
    }

}

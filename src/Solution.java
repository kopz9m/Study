import java.util.*;

public class Solution {
    public int countWays(List<String> domino) {
        int n = domino.size();
        int[][] adj = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && (domino.get(i).charAt(1) == domino.get(j).charAt(0))) {
                    adj[i][j] = 1;
                }
            }
        }
        int[] color = new int[n];
        int ans = 0;
        for (int i = 0; i < 3; i++) {
            Arrays.fill(color, -1);
            color[0] = i;
            ans = (ans + dfs(adj, color, 1, n)) % 1000000007;
        }
        return ans;
    }

    private int dfs(int[][] adj, int[] color, int i, int n) {
        if (i == n) {
            return 1;
        }
        int ans = 0;
        for (int c = 0; c < 3; c++) {
            boolean valid = true;
            for (int j = 0; j < n; j++) {
                if (adj[i][j] == 1 && color[j] == c) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                color[i] = c;
                ans = (ans + dfs(adj, color, i + 1, n)) % 1000000007;
                color[i] = -1;
            }
        }
        return ans;
    }
}

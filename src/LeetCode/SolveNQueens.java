package LeetCode;/**
 * @Author: Patrick
 * @Date: 2022-10-21-14:31
 * @Description:
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @description:
 * @author patrzhang
 * @date 21/10/2022 14:31
 * @version 1.0
 */
public class SolveNQueens {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList<>();
        boolean[][] used = new boolean[n][n];
        String[][] grid = new String[n][n];


        Deque<String> path = new ArrayDeque<>();



        return res;

    }

    public void dfs(
            int n,
            Deque path,
            boolean[] used,
            List res)
    {
        if(path.size() == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]){
                path.addLast(used[i]);
                used[i] = true;
                dfs(n,path,used,res);
                used[i] = false;
                path.removeLast();
            }
        }

    }
}

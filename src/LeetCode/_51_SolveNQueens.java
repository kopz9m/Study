package LeetCode;

import java.util.*;

/**
 * @Author: Patrick
 * @Date: 2023-03-19-19:52
 * @Description:
 */
public class _51_SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;

    }

    public void backtrack(List<List<String>> solutions,
                          int[] queens,
                          int n,
                          int row,
                          Set<Integer> columns,
                          Set<Integer> diagonals1,
                          Set<Integer> diagonals2) {
        if (row == n){
            solutions.add(generate(queens, n));
        }

        for (int i = 0; i < n; i++) {

            if (columns.contains(i)){
                continue;
            }

            if(diagonals1.contains(row - i)){
                continue;
            }
            if(diagonals2.contains(row + i)){
                continue;
            }
            queens[row] = i;
            columns.add(i);
            diagonals1.add(row - i);
            diagonals2.add(row + i);

            backtrack(solutions,queens,n,row + 1,columns,diagonals1,diagonals2);

            queens[row] = i;
            columns.remove(i);
            diagonals1.remove(row - i);
            diagonals2.remove(row + i);



        }




    }
    private List<String> generate(int[] queens, int n){
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row  = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }


}

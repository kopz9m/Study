package LeetCode;/**
 * @Author: Patrick
 * @Date: 2022-09-16-16:08
 * @Description:
 */

import java.util.*;

/**
 * @description:
 * @author patrzhang
 * @date 16/09/2022 16:08
 * @version 1.0
 */
public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> lists = combinationSum.combinationSum(new int[]{2, 3, 6, 7}, 7);

        lists.forEach(System.out::println);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        int len = candidates.length;

        List<List<Integer>> res = new ArrayList<>();

        if (len == 0) return res;

        Deque<Integer> path = new ArrayDeque();

        dfs(candidates, 0, len, target, path, res);

        return res;

    }

    /**
     * @param candidates 候选数组
     * @param begin      搜索起点
     * @param len        冗余变量，是 candidates 里的属性，可以不传
     * @param target     每减去一个元素，目标值变小
     * @param path       从根结点到叶子结点的路径，是一个栈
     * @param res        结果集列表
     */

    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {

        if (target < 0) {
            return;
        }

        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {

            path.addLast(candidates[i]);

            int newTarget = target - candidates[i];
            dfs(candidates, i, len, newTarget , path, res);

            path.removeLast();
        }

    }
}

package LeetCode;/**
 * @Author: Patrick
 * @Date: 2022-10-24-17:13
 * @Description:
 */

import java.util.*;

/**
 * @description: 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * @author patrzhang
 * @date 24/10/2022 17:13
 * @version 1.0
 */
public class CombinationSum2 {

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        List<List<Integer>> res = combinationSum2.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        res.forEach(System.out::println);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        int len = candidates.length;

        List<List<Integer>> res = new ArrayList<>();

        if(len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque();

        Arrays.sort(candidates);

        dfs(len, 0, target,candidates,path,res);


        return res;
    }
    public void dfs(int len,
                    int begin,
                    int target,
                    int[] candidates,
                    Deque path,
                    List<List<Integer>> res){

        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        if (target < 0){
            return;
        }


        for (int i = begin; i < len; i++) {

            if (i > begin && candidates[i] == candidates[i- 1] ){
                continue;
            }


                path.add(candidates[i]);
            dfs(len,i+1,target - candidates[i],candidates,path,res);
            path.removeLast();
        }

    }
}

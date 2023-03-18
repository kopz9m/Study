package LeetCode;/**
 * @Author: Patrick
 * @Date: 2022-10-27-13:51
 * @Description:
 */

import java.util.*;

/**
 * @author patrzhang
 * @version 1.0
 * @description: 90.
 * @date 27/10/2022 13:51
 */
public class SubsetsWithDup {
    public static void main(String[] args) {
        SubsetsWithDup subsets =new SubsetsWithDup();
        List<List<Integer>> res = subsets.subsetsWithDup(new int[]{1,2,2});
        res.forEach(System.out::println);

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {



        int len = nums.length;

        boolean[] used = new boolean[len];

        Deque path = new ArrayDeque<Integer>();

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        res.add(new ArrayList<>());

        dfs(nums, len, 0, 0, path, used, res);

        return res;
    }

    private void dfs(int[] nums, int len, int begin, int depth, Deque path, boolean[] used, List<List<Integer>> res) {
        if (depth > 0) {
            res.add(new ArrayList<>(path));
        }

        for (int i = begin; i < len; i++) {

            if (i > begin && nums[i] == nums[i-1]){
                continue;
            }

            if (!used[i] ) {
                path.addLast(nums[i]);
                used[i] = true;
                dfs(nums, len, i + 1, depth + 1, path, used, res);
                path.removeLast();
                used[i] = false;
            }

        }
    }
}

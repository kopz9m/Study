package LeetCode;/**
 * @Author: Patrick
 * @Date: 2022-10-27-13:33
 * @Description:
 */

import java.util.*;

/**
 * @description: no 78
 * @author patrzhang
 * @date 27/10/2022 13:33
 * @version 1.0
 */
public class Subsets {

    public static void main(String[] args) {
        Subsets subsets =new Subsets();
        List<List<Integer>> res = subsets.subsets(new int[]{1,2,3});
        res.forEach(System.out::println);

    }

    public List<List<Integer>> subsets(int[] nums) {

        int len = nums.length;

        boolean[] used = new boolean[len];

        Deque path = new ArrayDeque<Integer>();

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        res.add(new ArrayList<>());

        dfs(nums, len, 0,0, path, used, res);

        return res;

    }

    private void dfs(int[] nums, int len, int begin,int depth, Deque path, boolean[] used, List<List<Integer>> res) {
        if (depth > 0){
            res.add(new ArrayList<>(path));
        }

        for (int i = begin; i < len; i++) {
            if (!used[i]){
                path.addLast(nums[i]);
                used[i] = true;
                dfs(nums,len,i + 1,depth + 1, path, used,res);
                path.removeLast();
                used[i] = false;
            }

        }
    }

}

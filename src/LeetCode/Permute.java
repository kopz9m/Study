package LeetCode;/**
 * @Author: Patrick
 * @Date: 2022-10-21-10:50
 * @Description:
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author patrzhang
 * @version 1.0
 * @description:
 * @date 21/10/2022 10:50
 */
public class Permute {

    public static void main(String[] args) {
        Permute permute = new Permute();
        List<List<Integer>> res = permute.permute(new int[]{111, 222, 333, 444});

        res.forEach(System.out::println);

    }

    public List<List<Integer>> permute(int[] nums) {

        int len = nums.length;

        boolean[] used = new boolean[len];

        Deque path = new ArrayDeque<Integer>();

        List<List<Integer>> res = new ArrayList<>();

        dfs(nums, len, 0, path, used, res);

        return res;

    }

    public void dfs(
            int[] nums,
            int len,
            int depth,
            Deque path,
            boolean[] used,
            List res
    ) {

        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {

            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;
                dfs(nums, len, depth + 1, path, used, res);
                used[i] = false;
                path.removeLast();
            }
        }

    }
}

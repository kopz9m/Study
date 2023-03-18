package LeetCode;/**
 * @Author: Patrick
 * @Date: 2022-10-27-9:43
 * @Description:
 */

import javax.swing.text.html.HTMLDocument;
import java.util.*;

/**
 * @description:
 * @author patrzhang
 * @date 27/10/2022 9:43
 * @version 1.0
 */
public class PermuteUnique {

    public static void main(String[] args) {
        PermuteUnique permuteUnique = new PermuteUnique();
        List<List<Integer>> res = permuteUnique.permuteUnique(new int[]{1, 1, 2});

        res.forEach(System.out::println);

    }


    public List<List<Integer>> permuteUnique(int[] nums) {

        int len = nums.length;

        boolean[] used = new boolean[len];

        Deque path = new ArrayDeque<Integer>();

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        dfs(nums, len, 0,0, path, used, res);

        List<List<Integer>> newRes = new ArrayList<>();

        for (List item:res) {
            if (!newRes.contains(item)){
                newRes.add(item);
            }
        }

        return newRes;

    }

    private void dfs(int[] nums, int len, int begin,int depth, Deque path, boolean[] used, List<List<Integer>> res) {

        if (depth == len ){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {

//            if (i > 0 && nums[i] == nums[i - 1]){
//                continue;
//            }

            if (!used[i]){
                used[i] = true;
                path.addLast(nums[i]);
                dfs(nums,len,0 ,depth + 1,path,used,res);
                path.removeLast();
                used[i] = false;
            }
        }
    }


}

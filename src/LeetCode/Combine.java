package LeetCode;/**
 * @Author: Patrick
 * @Date: 2022-10-27-11:26
 * @Description:
 */

import java.util.*;

/**
 * @description: No.77
 * @author patrzhang
 * @date 27/10/2022 11:26
 * @version 1.0
 */
public class Combine {
    public static void main(String[] args) {
        Combine combine = new Combine();

        List<List<Integer>> res = combine.combine(4,2);

        res.forEach(System.out::println);

    }
    public List<List<Integer>> combine(int n, int k) {

        int totalLen = n;
        int len = k;

        boolean[] used = new boolean[totalLen + 1];

        Deque path = new ArrayDeque<Integer>();

        List<List<Integer>> res = new ArrayList<>();

        dfs(totalLen, len, 1,0, path, used, res);

        List<List<Integer>> newRes = new ArrayList<>();

        for (List item:res) {
            if (!newRes.contains(item)){
                newRes.add(item);
            }
        }

        return newRes;

    }

    private void dfs(int totalLen, int len, int begin,int depth, Deque path, boolean[] used, List<List<Integer>> res) {

        if (depth == len ){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < totalLen + 1; i++) {

            if (!used[i]){
                used[i] = true;
                path.addLast(i);
                dfs(totalLen,len,i + 1 ,depth + 1,path,used,res);
                path.removeLast();
                used[i] = false;
            }
        }
    }

}

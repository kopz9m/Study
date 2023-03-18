package LeetCode;

import org.omg.CORBA.CharSeqHelper;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @Author: Patrick
 * @Date: 2023-03-17-9:28
 * @Description:
 */
public class _113_PathSum {

    // 深度优先
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        dfs(root, list, targetSum, ans, 0);

        return ans;

    }

    private void dfs(TreeNode node, List<Integer> list, int targetSum, List<List<Integer>> ans, int curVal) {
        if (node == null) {
            return;
        }

        list.add(node.val);
        curVal += node.val;
        if (node.left == null && node.right == null && curVal == targetSum) {
            ans.add(new ArrayList<>(list));
        }

        dfs(node.left, list, targetSum, ans, curVal);

        dfs(node.right, list, targetSum, ans, curVal);
        list.remove(list.size() - 1);
        curVal -= node.val;
    }

    // 广度优先遍历
    public List<List<Integer>> bfs(TreeNode root, int targetSum) {

        List<List<Integer>> ans = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList();
        Queue<Integer> queueSum = new LinkedList<Integer>();
        queue.add(root);
        queueSum.add(0);
        HashMap<TreeNode, TreeNode> map = new HashMap<>();

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int rec = queueSum.poll() + cur.val;

            if (cur.left == null && cur.right == null ) {
                if (rec == targetSum){
                    ans.add(getPath(cur,map));
                }
            } else {
                if (cur.left != null) {
                    queue.add(cur.left);
                    map.put(cur.left, cur);
                    queueSum.add(rec);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    map.put(cur.right, cur);
                    queueSum.add(rec);
                }
            }

        }
        return ans;
    }


    private List<Integer> getPath(TreeNode node, HashMap<TreeNode,TreeNode> map){
        List<Integer> list = new ArrayList<>();
        do{
            list.add(node.val);
            node = map.get(node);
        }while (map.get(node)!=null);
        Collections.reverse(list);
        return list;
    }


}

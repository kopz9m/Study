package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Patrick
 * @Date: 2023-03-13-18:57
 * @Description: 二叉树 中序遍历
 */
public class _94_InorderTraversal {

    // 深度优先
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }


    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
    }



    //    Morris 算法

    private void dfs2(TreeNode root) {
        TreeNode pre;
        while (root != null) {
            if (root.left != null) {
                // 找到前驱节点 pre
                pre = root.left;
                while (pre.right != null && pre.right != root) {
                    pre = pre.right;
                }
                if (pre.right == root) {
                    // 断开连接
                    System.out.println(pre.val);
                    pre.right = null;
                    root = root.right;
                } else {
                    // 到达左子树最右端
                    pre.right = root;
                    root = root.left;
                }
            } else {
                System.out.println(root.val);
                root = root.right;
            }
        }
    }

}



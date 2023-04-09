package LeetCode;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @Author: Patrick
 * @Date: 2023-03-18-20:03
 * @Description: 二叉树展开为链表
 */
public class _114_Flatten {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new LinkedList();
        stack.push(root);
        TreeNode pre = null;
        while (stack.size() > 0) {
            TreeNode curr = stack.pop();
            if (pre != null) {
                pre.left = null;
                pre.right = curr;
            }
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
            pre = curr;
        }
    }

    // 莫里斯
    public void flatten2(TreeNode root) {
        if (root == null) return;
        while(root != null){
            TreeNode next = root.right;
            if (root.left != null){
                TreeNode pre = root.left;
                while(pre.right != null){
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                TreeNode tmp = root;
                next = root.left;
                tmp.left = null;
            }

            root = next;

        }
    }


}

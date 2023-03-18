package LeetCode;

import java.util.List;

/**
 * @Author: Patrick
 * @Date: 2023-03-15-15:55
 * @Description: 验证二叉搜索树
 */
public class _95_ValidBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode node, long minVal, long maxVal) {
        if (node == null) {
            return true;
        }
        if (node.val <= minVal || node.val >= maxVal) {
            return false;
        }
        return dfs(node.left, minVal, node.val) && dfs(node.right, node.val, maxVal);
    }



    public static void main(String[] args) {
        _95_ValidBinarySearchTree validBinarySearchTree = new _95_ValidBinarySearchTree();
        validBinarySearchTree.isValidBST(new TreeNode());
    }

}

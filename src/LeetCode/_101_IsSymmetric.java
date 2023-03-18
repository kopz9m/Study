package LeetCode;

/**
 * @Author: Patrick
 * @Date: 2023-03-16-17:21
 * @Description:
 */
public class _101_IsSymmetric {

    public boolean isSymmetric(TreeNode root) {


        return dfs(root.left, root.right);

    }

    private boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if ((p != null && q == null) || (p == null && q != null) || p.val != q.val) {
            return false;
        }

        if (dfs(p.left, q.right)) {
            return dfs(p.right, q.left);
        } else {
            return false;
        }

    }


}

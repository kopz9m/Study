package LeetCode;

/**
 * @Author: Patrick
 * @Date: 2023-03-16-16:57
 * @Description:
 */
public class _100_IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }

    private boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if ((p != null && q == null) || (p == null && q != null) || p.val != q.val) {
            return false;
        }

        if(dfs(p.left, q.left)){
            return dfs(p.right, q.right);
        } else {
            return false;
        }

    }

}

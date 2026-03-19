
@SuppressWarnings("unused")
class SymmetricTree {
    /*
        time O(n)
        space O(h)
            ▪︎ balanced tree: O(logn)
            ▪︎ skew tree: O(n)
    */
    public boolean isSymmetric(TreeNode root) {
        return isSame(root.left, root.right);
    }

    private boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p == null || q == null) || (p.val != q.val)) {
            return false;
        }
        return isSame(p.left, q.right) && isSame(p.right, q.left);
    }
}

class TreeNode {

    @SuppressWarnings("unused")
    int val;
    TreeNode left;
    TreeNode right;

    @SuppressWarnings("unused")
    TreeNode() {
    }

    @SuppressWarnings("unused")
    TreeNode(int val) {
        this.val = val;
    }

}

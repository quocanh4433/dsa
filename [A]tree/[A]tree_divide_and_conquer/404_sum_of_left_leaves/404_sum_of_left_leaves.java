
@SuppressWarnings("unused")
class SumOfLeftLeaves {

    /*
        time O(n)
        space O(h)
            ▪︎ balanced tree: h = logn
            ▪︎ skew tree: h = On

     */
    int res = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;

        if (root.left != null) {
            if (isLeaf(root.left)) {
                sum += root.left.val;
            } else {
                sum += sumOfLeftLeaves(root.left);
            }
        }

        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}

class TreeNode {

    @SuppressWarnings("unused")
    int val;
    @SuppressWarnings("unused")
    TreeNode left;
    @SuppressWarnings("unused")
    TreeNode right;

    @SuppressWarnings("unused")
    TreeNode() {
    }

    @SuppressWarnings("unused")
    TreeNode(int val) {
        this.val = val;
    }

}

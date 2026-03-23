

@SuppressWarnings("unused")
class MaximumDepthOfBinaryTree_DFS {

    /*
        time O(n)
        space O(h)
            ▪︎ balanced tree: h = logn
            ▪︎ skew tree: h = On
     */
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;

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


@SuppressWarnings("unused")
class BinaryTreeMaximumPathSum {

    /*
        time O(n)
        space O(h)
            ▪︎ balanced tree: O(logn)
            ▪︎ skew tree: O(n)

        postorder ~ divide & conquer

        at each node, 
            we need to combine left side, right side and current node 
                ~ res = Math.max(res, left + right + node.val)

            however, when returning to parent, we only take the maximum path sum from one side
                ~ node.val + Math.max(left, right);

        Note: 
            ignore the negative paths by treating them as 0
     */
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        res = Math.max(res, left + right + node.val);

        return node.val + Math.max(left, right);
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

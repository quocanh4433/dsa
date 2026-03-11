

@SuppressWarnings("unused")
class InvertBinaryTree_DivideAndConquer {

    /*
        time O(n)
        space O(h) ~ O(n)

        post_order
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
           
        TreeNode leftSide = invertTree(root.left);
        TreeNode rightSide = invertTree(root.right);

        root.left = rightSide;
        root.right = leftSide;

        return root;
    }
}

class TreeNode {

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


class InsertIntoABinarySearchTree_DFS {

    /*
        time O(n)
        space O(h)
            ▪︎ balanced tree: h = logn
            ▪︎ skew tree: h = On
    
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            if (root.left != null) {
                root.left = insertIntoBST(root.left, val);
            } else {
                root.left = new TreeNode(val);
            }

        } else if (val > root.val) {
            if (root.right != null) {
                root.right = insertIntoBST(root.right, val);
            } else {
                root.right = new TreeNode(val);
            }
        }

        return root;
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

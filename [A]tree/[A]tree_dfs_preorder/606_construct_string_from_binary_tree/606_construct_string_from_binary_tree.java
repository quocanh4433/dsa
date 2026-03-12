
@SuppressWarnings("unused")
class ConstructStringFromBinaryTree {

    /*
        time O(n)
        space O(h)
            ▪︎ balanced tree: O(logn)
            ▪︎ skew tree: O(n)
     */
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }

        if (root.left == null && root.right == null) {
            return Integer.toString(root.val);
        }

        if (root.right == null) { // vân có thể giải với trương hợp root.left == null
            return root.val + "(" + tree2str(root.left) + ")";
        }

        return root.val + "(" + tree2str(root.left) + ")" + "(" + tree2str(root.right) + ")";
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


@SuppressWarnings("unused")
class LowestCommonAncestorOfABinarySearchTree_BST_Attribute {

    /*
        time O(n)
        space O(1)

        for interview
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                // ca 2 node nam ben trai
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                // ca 2 node nam ben phai
                root = root.right;
            } else {
                break;
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

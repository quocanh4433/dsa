
@SuppressWarnings("unused")
class InsertIntoABinarySearchTree_BFS_Attribute {


    /*
        time O(n)
        space O(1)
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null) {
            return node;
        }

        TreeNode cur = root;

        while (cur != null) {
            if (val < cur.val) {
                if (cur.left == null) {
                    cur.left = node;
                    break;
                }
                cur = cur.left;
            } else {
                // new value does not exist in the original BST.
                // nên val > cur.left 
                if (cur.right == null) {
                    cur.right = node;
                    break;
                }
                cur = cur.right;
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

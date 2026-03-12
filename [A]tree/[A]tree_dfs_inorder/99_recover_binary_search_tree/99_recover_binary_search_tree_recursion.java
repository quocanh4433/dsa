
@SuppressWarnings("unused")
class RecoverBinarySearchTree_Recursion {

    /*
        ▪︎ T/C: inorder trong BST được dãy sắp xếp tăng dần

        ▪︎ theo yêu cầu chỉ có 2 node cần swap
            
        time O(n)
        space O(h)
            ▪︎ balanced tree: O(logn)
            ▪︎ skew tree: O(n)
     */
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTree(TreeNode root) {
        inorder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);

        if (prev.val > node.val) {
            if (first == null) {
                first = prev;
            }
            second = node;
        }

        prev = node;

        inorder(node.right);
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


@SuppressWarnings("unused")
class ConstructBinarySearchTreeFromPreorderTraversal {
     /*
        time O(n)
        space O(h)
            ▪︎ balanced tree: O(logn)
            ▪︎ skew tree: O(n)

        ý tưởng:
            ▪︎ không cần chia left - right
            ▪︎ chỉ cần preorde + bound + index 

     */
    int index = 0; // cho biết đang đi đến đâu trong preorder

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }

    public TreeNode build(int[] preorder, int bound) {
        /*
            Tại sao preorder[index] > bound?
            
         */
        if (index == preorder.length || preorder[index] > bound) {
            return null;
        }

        int rootVal = preorder[index++];
        TreeNode root = new TreeNode(rootVal);

        root.left = build(preorder, rootVal);
        root.right = build(preorder, bound);

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

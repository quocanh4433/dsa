
@SuppressWarnings("unused")
class DiameterOfBinaryTree {

    /*
        time O(n)
        space O(h)
            ▪︎ balanced tree: O(logn)
            ▪︎ skew tree: O(n)

     */
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        /*
            2 dòng cuối khá giống nhau nhưng không liên quan gì tới nhau

            res = Math.max(res, left + right);
                để cập nhât đường kính


            return 1 + Math.max(left, right);
                không liên quan đến đường kính
                chỉ trả về chiều cao node hiện tại
                +1 là node hiện tại
         */
        res = Math.max(res, left + right); //  -> tính diameter
        return 1 + Math.max(left, right); //  -> trả height
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

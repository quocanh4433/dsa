
@SuppressWarnings("unused")
class CountGoodNodesInBinaryTree_Recursion {

    /*
        time O(n)
        space O(h)
            ▪︎ balanced tree: O(logn)
            ▪︎ skew tree: O(n)
     */
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    // @param maxSoFar: giá trị lớn nhất trên đường đi
    public int dfs(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }

        int count = 0;

        if (node.val >= maxSoFar) {
            count++;
            maxSoFar = node.val;
        }

        count += dfs(node.left, maxSoFar);
        count += dfs(node.right, maxSoFar);

        return count;
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

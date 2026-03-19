
@SuppressWarnings("unused")
class PathSum {
    /*
        time O(n)
        space O(h)
            ▪︎ balanced tree: O(logn)
            ▪︎ skew tree: O(n)

        hasPathSum thỏa 2 diều kiền
            ▪︎ đi đến leaf node
            ▪︎ remain = 0; 
    
     */
    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        
        int remain = targetSum - root.val;

        if(remain == 0 && isLeaf(root)) {
            return true;
        }
       
        boolean left = hasPathSum(root.left, remain);
        boolean right = hasPathSum(root.right, remain);

        return left || right;
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

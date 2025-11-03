package PathSum;

import common.TreeNode;

public class PathSum {

    public boolean isLeaf(TreeNode node) {
        return node.left == null & node.right == null;
        // 🔥 Tại sao ở đây chỉ có một dấu & nhưng logic vần đúng
        // Nó khác gì với dấu &&
    }

    /*
     * Time complexity: O(n)
     * 
     * Space complexity: O(h)
     * 
     * h: height of tree
     * n: number of node
     * 
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        int remain = targetSum - root.val;
        if (remain == 0 && isLeaf(root)) {
            return true;
        }

        boolean leftSide = hasPathSum(root.left, remain);
        boolean rightSide = hasPathSum(root.right, remain);

        return leftSide || rightSide;
    }

    // JUST REVISE
    public boolean hasPathSum_2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        targetSum -= root.val;
        if (targetSum == 0 && root.left == null && root.right == null) {
            return true;
        }

        boolean leftSide = hasPathSum(root.left, targetSum);
        boolean rightSide = hasPathSum(root.right, targetSum);

        return leftSide || rightSide;
    }

    public static void main(String[] args) {

    }
}

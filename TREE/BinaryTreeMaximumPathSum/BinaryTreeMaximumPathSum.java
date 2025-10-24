package BinaryTreeMaximumPathSum;

import common.TreeNode;

public class BinaryTreeMaximumPathSum {


    /*
     * SOLUTION: DFS - OPTIMAL
     * 
     * Time complexity: O(n)
     * 
     * Space complexity: O(h) ~ O(n)
     * 
     */


    public int maxPathSum(TreeNode root) {
        int[] maxPathSum = {root.val};
        dfsBranchSum(root, maxPathSum); // ✅

        // maxPathSum[0] = dfsBranchSum(root, maxPathSum); ❌
        // dfs() trả về branchsum, maxPathSum đã được cập nhật

        return maxPathSum[0];
    }

    public int dfsBranchSum(TreeNode node, int[] maxPathSum) {
        if(node == null) return 0;

        int leftMax = dfsBranchSum(node.left, maxPathSum);
        int rightMax = dfsBranchSum(node.right, maxPathSum);

        // Nếu leftMax or rightMax < 0 làm giảm maxPathSum. Nên trả về 0
        leftMax = Math.max(leftMax, 0);
        rightMax = Math.max(rightMax, 0);

        // Tính maxPathSum mới
        maxPathSum[0] = Math.max(maxPathSum[0], node.val + leftMax + rightMax);

        return node.val + Math.max(leftMax, rightMax);
    }


    public static void main(String[] args) {
        
    }
}

package PathSum;

import common.TreeNode;

public class PathSum {
    public boolean isLeaf(TreeNode node) {
        return node.left == null & node.right == null;
    }

    /*
     * Time complexity: O(n)
     * 
     * Space complexity: O(h)
     * 
     * h: hieght of tree
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
    
    
    public static void main(String[] args) {
        
    }
}

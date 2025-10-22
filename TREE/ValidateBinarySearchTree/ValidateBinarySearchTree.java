package ValidateBinarySearchTree;

import common.TreeNode;

public class ValidateBinarySearchTree {

    /*
    SOLUTION 1: Depth First Search
     * Time: O(n)
     * 
     * Space:
     *  - O(h)
     *  - Cây nghiên 1 bên O(n)
     *  - Cây cân bằng O(logn)
     * 
     * 
     */

    public static boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean dfs(TreeNode node, long left, long right) {
        if (node == null) {
            return true;
        }

        int value = node.val;
        if (!(value > left && value < right)) {
            return false;
        }

        return dfs(node.left, left, value) && dfs(node.right, value, right);
    }



    /*
     * SOLUTION 2: Breath First Search
     * 
     */
    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(3);

        n0.left = n1; n0.right = n2; 

        System.out.println(isValidBST(n0));
    }
}

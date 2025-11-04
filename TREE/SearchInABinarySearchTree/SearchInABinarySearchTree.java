package SearchInABinarySearchTree;

import common.TreeNode;

public class SearchInABinarySearchTree {

    /*
     * SOLUTION 1: RECURSION
     * 
     * Time complexity: O(h)
     * Space complexity: O(h) stak recursion
     */
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (val > root.val) {
            return searchBST(root.right, val);
        } else if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return root;
        }
    }

    /*
     * SOLUTION 1.1: RECURSION
     * 
     * Time complexity: O(h)
     * Space complexity: O(h) stak recursion
     */
    public static TreeNode searchBST_2(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        if (val > root.val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }


    /*
     * SOLUTION 2: ITERATIVE
     * 
     * Time complexity: O(h)
     * Space complexity: O(1)
     */
    public static TreeNode searchBST_3(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }

    public static void main(String[] args) {

    }
}

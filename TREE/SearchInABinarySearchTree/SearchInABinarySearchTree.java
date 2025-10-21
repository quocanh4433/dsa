package SearchInABinarySearchTree;

import common.TreeNode;

public class SearchInABinarySearchTree {

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

    public static void main(String[] args) {

    }
}

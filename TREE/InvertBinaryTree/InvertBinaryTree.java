package TREE.InvertBinaryTree;

import TREE.common.TreeNode;

public class InvertBinaryTree {

    /*
     * BRAINSTORM
     * 
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        while (true) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (left != null || right != null) {
                root.left = right;
                root.right = left;
                invertTree(root.left);
                invertTree(root.right);
            }
            break;
        }
        return root;
    }

    /*
     * OPTIMIZED
     * 
     */
    public TreeNode invertTree_2(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {

    }
}

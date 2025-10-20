package TREE.DeleteNodeInABST;

import TREE.common.TreeNode;

public class DeleteNodeInABST {

    /*
    🕓 Time complexity: O(n)
    💾 Space complexity: O(1)
     */
    public TreeNode findRightMinNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode rightMinNode = root;
        while (rightMinNode.left != null) {
            rightMinNode = rightMinNode.left;
        }
        return rightMinNode;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else { // key == root.val
            // TH1: key la leaf node
            if (root.left == null && root.right == null) {
                return null;
            }

            // TH2: chi co 1 node con ben trai
            if (root.left != null & root.right == null) {
                return root.left;
            }

            // TH3: chi co 1 node con ben phai
            if (root.right != null & root.left == null) {
                return root.right;
            }

            // TH4: tồn tại 2 node con
            // Cách 1: Tìm node nhỏ nhất bên phải OR Cách 2: tìm node lớn nhất bên trái
            // Trong bài này dùng cách 1
            // Timf node nhỏ nhất bên phải
            TreeNode minNode = findRightMinNode(root.right);

            // Thay thế value node cần xóa băng node nhỏ nhất bên phải
            root.val = minNode.val;

            // Xóa node nhỏ nhất bên phải
            root.right = deleteNode(root.right, minNode.val);
        }
        return root;
    }

    public static void main(String[] args) {

    }
}

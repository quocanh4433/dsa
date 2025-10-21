package InsertIntoABinarySearchTree;

import TREE.common.TreeNode;

public class InsertIntoABinarySearchTree {

    /*
    🕓 Time complexity: O(h) 
    💾 Space complexity: O(1)
    
    h: chiều cao Tree
    
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);

        if (root == null) {
            root = newNode;
            return root;
        } else {
            TreeNode temp = root;

            while (true) {
                if (val > temp.val) {
                    if (temp.right == null) {
                        temp.right = newNode;
                        break;
                    } else {
                        temp = temp.right;
                    }
                } else {
                    if (temp.left == null) {
                        temp.left = newNode;
                        break;
                    } else {
                        temp = temp.left;
                    }
                }

            }
        }
        return root;
    }


    /*
    SOLUTION 2: RECURSION


    🕓 Time complexity: O(h) 
    💾 Space complexity: O(h) do call stack.
    
    h: chiều cao Tree
    
     */
    public TreeNode insertIntoBST_Recursion(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val > root.val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                insertIntoBST_Recursion(root.right, val);
            }
        } else {
            if (root.right == null) {
                root.left = new TreeNode(val);
            } else {
                insertIntoBST_Recursion(root.left, val);
            }
        }

        return root;
    }

    public static void main(String[] args) {

    }
}

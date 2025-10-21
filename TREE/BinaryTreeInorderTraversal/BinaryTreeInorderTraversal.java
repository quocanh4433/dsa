package BinaryTreeInorderTraversal;

import common.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return result;

        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);

        return result;
    }
    public static void main(String[] args) {
        
    }
}

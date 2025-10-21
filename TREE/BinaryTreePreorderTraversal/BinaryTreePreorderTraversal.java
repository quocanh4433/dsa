package BinaryTreePreorderTraversal;

import common.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return result;

        result.add(root.val);

        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return result;
    }
    public static void main(String[] args) {
        
    }
}

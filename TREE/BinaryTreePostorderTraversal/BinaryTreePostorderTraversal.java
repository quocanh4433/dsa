package BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class BinaryTreePostorderTraversal {
     List<Integer> result = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return result;

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        result.add(root.val);

        return result;
    }
    
    public static void main(String[] args) {
        
    }
}

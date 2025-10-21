package BinaryTreeLevelOrderTraversal;

import common.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    /*
     * SAI LOGIC + SYNTAX❌
     */
    public List<List<Integer>> levelOrder_Error(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            for(int i = queue.size(); i > 0 ; i--) { 
            /*
                for(int i = 0; i < queue.size(); i++) ❌ -> for(int i = queue.size(); i > 0 ; i--) ✅

                👉 Tại sao for(int i = 0; i < queue.size(); i++) lại sai ?
                Vì queue.size() thay đổi trong thân vòng khi ta thêm con nên sẽ phá vỡ việc phân tầng

             */
                TreeNode node = queue.poll();
                if(node != null) {
                    level.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }

            if(level.size() > 0) { // level.length ❌ -> level.size() ✅
                result.add(level);
            }
        }

        return result;
    }

    /*
     * CODE ĐÚNG ✅
     * 
     * BREATH FIRST SEARCH
     * 
     * Time complexit: O(n)
     * 
     * Space complexity: O(n)
     * 
     * 
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (node != null) {
                    level.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }

            if (!level.isEmpty()) {
                result.add(level);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        
    }
}

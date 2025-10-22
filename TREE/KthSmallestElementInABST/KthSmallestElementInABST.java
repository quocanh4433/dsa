package KthSmallestElementInABST;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

public class KthSmallestElementInABST {

    /*
     * SOLUTION 1: Inorder traversal 
     * 
     * Time complaxity: O(n)
     * Space complexity: O(n)
     * 
     */

    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;

        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);

        if(k <= list.size()) {
            return list.get(k-1);
        }

        return -1;
    }

    public void inorderTraversal(TreeNode root, List<Integer> list) {
        if(root == null) return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }


    /*
     * SOLUTION 2: Iterative DFS (Optimal)
     * 
     * Time complaxity: O(n)
     * Space complexity: O(n)
     * 
     */
     public int kthSmallest_2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // 1️⃣ Đi càng sâu về trái càng tốt
            while (curr != null) {
                stack.push(curr);     // ✅ push chính curr
                curr = curr.left;
            }

            // 2️⃣ Lấy node nhỏ nhất chưa duyệt
            curr = stack.pop();
            k--;

            // 3️⃣ Khi đã duyệt đến phần tử nhỏ thứ k
            if (k == 0) return curr.val;

            // 4️⃣ Chuyển sang phải
            curr = curr.right;
        }

        return -1; // nếu k không hợp lệ
    }

    public static void main(String[] args) {
        
    }
}

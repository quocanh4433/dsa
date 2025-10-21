package SubtreeOfAnotherTree;

import common.TreeNode;

public class SubtreeOfAnotherTree {
    public boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        }
        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }

    /*
     * LOGIC SAI ❌
     */
    public boolean isSubtree_Error(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }

        
        if(root.val != subRoot.val) {
            isSubtree(root.left, subRoot);
            isSubtree(root.right, subRoot);

            // gọi đệ quy nhưng không dùng kết quả trả về, 
            // nên giá trị true/false từ các nhánh con bị bỏ qua 
            // → chương trình luôn tiếp tục chạy xuống dòng `return isSameTree(root, subRoot);`
            // → gây sai kết quả
        }

        return isSameTree(root, subRoot);
    }


    /* 
     * Depth First Search (DFS)
     *    
     * LOGIC ĐÚNG ✅
     * 
     * Time complexity: O(m * n);
     * Space complexity: O(m + n)
     * 
     * n = number of nodes in the main tree root
     * m = number of nodes in the subtree subRoot
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        
        if (isSameTree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }


    /*
     * SOLUTION 2: Serialization And Pattern Matching
     * 
     * Time complexity: O(m + n);
     * 
     * Space complexity: O(m + n)
     * 
     * n = number of nodes in the main tree root
     * m = number of nodes in the subtree subRoot
     * 
     * 
     * ❓ ĐỌC SOLUTION XONG CUNG KHÔNG BIẾT LÀM ❓
     * 
     */

   
    public static void main(String[] args) {
        
    }
}

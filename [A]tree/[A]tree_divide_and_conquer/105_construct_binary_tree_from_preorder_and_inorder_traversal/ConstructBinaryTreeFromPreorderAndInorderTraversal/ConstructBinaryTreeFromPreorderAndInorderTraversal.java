
package ConstructBinaryTreeFromPreorderAndInorderTraversal;

import common.TreeNode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    /*
     * 🕓 Time complexity: O(n^2)
     * 
     * 💾 Space complexity: O(h) - worst case: khi cây mất cân bằng -> O(n)
     * h: chiều cao của cây
     * 
     * 👉 Tại sao time là O(n^2) ?
     * 
     * 👉 Tại sao TreeNode result  không bị reset qua nhiều lần đệ quy?
     * 
     * 
     */

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;

        TreeNode result = new TreeNode(preorder[0]);

        // Xác định index của root node trong inorder
        int mid = -1;
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == preorder[0]) {
                mid = i;
                break;
            }
        }

        // Mid chia inorder[] thành 2 phần
        // Bên phải mid: nhánh phải của root node 
        // Bên trái mid: nhánh trái của root node
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, mid); 
        int[] inorderRight = Arrays.copyOfRange(inorder, mid + 1, inorder.length);

        // Mid cũng cho biêt số lượng node bên trái và bên phải của preorder[]
        // Từ 1 -> mid:       nhánh trái của root node
        // Từ mid + 1 -> n:   nhánh phải của root node
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, mid + 1);
        int[] preorderRight = Arrays.copyOfRange(preorder, mid + 1, preorder.length);

        // Xây dựng cây bằng đệ quy
        result.left = buildTree(preorderLeft, inorderLeft);
        result.right = buildTree(preorderRight, inorderRight);

        return result;
    }

    /**
     * SOLUTION 2: HashMap + index boundary
     * 
     * 
     * 🕓 Time complexity: O(n)
     * 
     * 💾 Space complexity: O(n)
     */
    static Map<Integer, Integer> indices = new HashMap<>();
    static int preIdx = 0;
    
    public static TreeNode buildTree_2(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indices.put(inorder[i], i);
        }
        return dfs(preorder, 0, preorder.length - 1);
    }

    public static TreeNode dfs(int[] preorder, int l, int r) {
        if (l > r) {
            return null;
        }
        int value = preorder[preIdx];
        preIdx += 1;
        TreeNode node = new TreeNode(value);
        int mid = indices.get(value);
        node.left = dfs(preorder, l, mid - 1);
        node.right = dfs(preorder, mid + 1, r);
        return node;
    }
    
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        System.out.println(buildTree_2(preorder, inorder));
    }
}

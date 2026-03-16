import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    /*
        time O(n)
        space O(h)
            ▪︎ balanced tree: O(logn)
            ▪︎ skew tree: O(n)

        ý tưởng:
            ▪︎ tạo map postorder với key: node.val - val: index
            ▪︎ duyệt preorder 
                ⋄ 

     */
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }

        return dfs(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode dfs(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        if (preStart == preEnd) {
            return root;
        }

        // leftSide
        int leftRoot = preorder[preStart + 1];

        int index = map.get(leftRoot);

        int leftSize = index - postStart + 1;

        
        root.left = dfs(preorder, preStart + 1, preStart + leftSize, postorder, postStart, index);
        root.right = dfs(preorder, preStart + leftSize + 1, preEnd, postorder, index + 1, postEnd - 1);

        return root;
    }
}

class TreeNode {

    @SuppressWarnings("unused")
    int val;
    TreeNode left;
    TreeNode right;

    @SuppressWarnings("unused")
    TreeNode() {
    }

    @SuppressWarnings("unused")
    TreeNode(int val) {
        this.val = val;
    }

}

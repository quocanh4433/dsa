import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    /*
        time O(n)
        space O(h)
            ▪︎ balanced tree: O(logn)
            ▪︎ skew tree: O(n)

        ý tưởng
            ▪︎ lưu value-index của inorder trong map
            ▪︎ duyệt từng node postorder
                ▪︎ lấy index của node từ map
                ▪︎ index cho biết left và right
     */
    Map<Integer, Integer> map = new HashMap<>();
    int indexPostorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        indexPostorder = postorder.length - 1;
        return dfs(postorder, 0, postorder.length - 1);
    }

    public TreeNode dfs(int[] postorder, int l, int r) {
        if (l > r) {
            return null;
        }

        int rootVal = postorder[indexPostorder--];
        TreeNode root = new TreeNode(rootVal);

        int index = map.get(rootVal);

        // postorder nên build right trước
        root.right = dfs(postorder, index + 1, r);
        root.left = dfs(postorder, l, index - 1);

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

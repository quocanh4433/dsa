import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    /*
        time O(n)
        space O(h)
            ▪︎ balanced tree: O(logn)
            ▪︎ skew tree: O(n)

        ý tưởng
            ▪︎ lưu value-index của inorder trong map
            ▪︎ duyệt từng node preoder
                ▪︎ lấy index của node từ map
                ▪︎ index cho biết left và right
     */
    

    Map<Integer, Integer> map = new HashMap<>();
    int indexPreorder = 0;


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, inorder.length - 1);
    }

    public TreeNode dfs(int[] preorder, int l, int r) {
        if(l > r) return null;

        int rootVal = preorder[indexPreorder++];
        TreeNode root = new TreeNode(rootVal);

        /*
            index trong inorder cho biết
                ▪︎ bên trái index là left
                ▪︎ bên phải index là right
        */
        int index = map.get(rootVal);

        root.left = dfs(preorder, l, index - 1);
        root.right = dfs(preorder, index + 1, r);

        return root;
    }
}

class TreeNode {

    @SuppressWarnings("unused")
    int val;
    @SuppressWarnings("unused")
    TreeNode left;
    @SuppressWarnings("unused")
    TreeNode right;

    @SuppressWarnings("unused")
    TreeNode() {
    }

    @SuppressWarnings("unused")
    TreeNode(int val) {
        this.val = val;
    }

}

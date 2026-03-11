
import java.util.Stack;

@SuppressWarnings("unused")
class InvertBinaryTree_Stack {

    /*
        time O(n)
        space O(h)
            ▪︎ balanced tree: O(logn)
            ▪︎ skew tree: O(n)

        pre_order
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
           
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();

            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;

            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }

        return root;

    }
}

class TreeNode {

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

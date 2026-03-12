
import java.util.*;

@SuppressWarnings("unused")
class BinaryTreeInorderTraversal {

    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }

        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);

        return res;
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


import java.util.*;

@SuppressWarnings("unused")
class LeafSimilarTrees_Stack {

    /*
        time O(n + m)
        space O(n + m)
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = getLeaf(root1);
        List<Integer> leaf2 = getLeaf(root2);
        return leaf1.equals(leaf2);
    }

    public List<Integer> getLeaf(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        if (node == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        while (!stack.empty()) {
            TreeNode cur = stack.pop();

            if (cur.left == null && cur.right == null) {
                res.add(cur.val);
            }

            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }

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

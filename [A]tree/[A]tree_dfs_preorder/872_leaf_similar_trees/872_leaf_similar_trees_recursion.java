
import java.util.*;

@SuppressWarnings("unused")
class LeafSimilarTrees_Recursion {

    /*
        time O(n + m)
        space O(n + m)
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        dfs(root1, left);
        dfs(root2, right);

        if (left.size() != right.size()) {
            return false;
        }

        for (int i = 0; i < left.size(); i++) {
            if (!left.get(i).equals(right.get(i))) {
                return false; // object nên so sánh băng equal
            }
        }

        return true;

        /*
            thay vì kiểm tra băng if() + for()

            đơn giản 
            return left.equals(right);
         */
    }

    public void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }

        dfs(node.left, list);
        dfs(node.right, list);
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

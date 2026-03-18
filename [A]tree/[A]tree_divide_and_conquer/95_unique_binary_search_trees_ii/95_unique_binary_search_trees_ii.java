import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
class UniqueBinarySearchTreesII {
    /*
        time O(Cn * n)
        space O(Cn * n)
            ▪︎ có Catalan(n) cây
            ▪︎ mỗi cây có n node
    */
    public List<TreeNode> generateTrees(int n) {
        if (n < 0) {
            return new ArrayList<>();
        }
        return buildTree(1, n);
    }

    public List<TreeNode> buildTree(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSide = buildTree(start, i - 1);
            List<TreeNode> rightSide = buildTree(i + 1, end);

            for (TreeNode left : leftSide) {
                for (TreeNode right : rightSide) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }

        }

        return res;
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

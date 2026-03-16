
@SuppressWarnings("unused")
class SmallestSubtreeWithAllTheDeepestNodes {

    /*
        time: O(n)
        ▪︎ each node is visited exactly once during DFS.

        space: O(h)
        ▪︎ recursion stack depends on tree height.

            balanced tree → O(log n)
            skew tree     → O(n)

     */
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    class Pair {

        int depth;
        TreeNode node;

        Pair(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }

    public Pair dfs(TreeNode root) {
        if (root == null) {
            return new Pair(0, null);
        }

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        if (left.depth > right.depth) {
            return new Pair(left.depth + 1, left.node);
        } else if (left.depth < right.depth) {
            return new Pair(right.depth + 1, right.node);
        } else {
            return new Pair(left.depth + 1, root);
        }
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

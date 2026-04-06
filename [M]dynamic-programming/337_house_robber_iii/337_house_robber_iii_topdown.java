
@SuppressWarnings("unused")
class HouseRobberIII_TopDown {

    /*
        recursion + memo (top-down)

        time O(n)
        space O(n)
   
     */

    Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        // option 1: rob root
        int robRoot = root.val;

        if (root.left != null) {
            robRoot += rob(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            robRoot += rob(root.right.left) + rob(root.right.right);
        }

        // option 2: not rob root
        int notRobRoot = rob(root.left) + rob(root.right);

        int res = Math.max(robRoot, notRobRoot);
        memo.put(root, res);
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

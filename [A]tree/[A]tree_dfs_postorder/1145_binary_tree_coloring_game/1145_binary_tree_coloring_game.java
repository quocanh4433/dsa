
@SuppressWarnings("unused")
class BinaryTreeColoringGame {

    /*

        giải thích đề:
            ▪︎ player1 chiếm node x, từ x có thể lan ra 3 vùng righ, left hoặc parent
            ▪︎ nếu 1 trong 3 vùng có số node > n/2 (n: tổng số node), thì player2 thắng


        time: O(n)
            ▪︎ each node is visited exactly once during DFS.

        space: O(h)
            ▪︎ recursion stack depends on tree height.

            balanced tree → O(log n)
            skew tree     → O(n)
     */
    int left = 0;
    int right = 0;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        count(root, x);

        int parent = n - left - right - 1; // (-1: trừ node x)

        int max = Math.max(parent, Math.max(left, right));

        return max > n / 2;
    }

    public int count(TreeNode node, int x) {
        if (node == null) {
            return 0;
        }

        int l = count(node.left, x);
        int r = count(node.right, x);

        if (node.val == x) {
            left = l;
            right = r;
        }

        return l + r + 1;
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

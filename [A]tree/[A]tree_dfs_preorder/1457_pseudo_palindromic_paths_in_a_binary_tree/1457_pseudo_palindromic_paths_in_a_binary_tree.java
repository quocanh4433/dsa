
class PseudoPalindromicPathsInABinaryTree {

    /*
        pseudo-palindrome nghĩa là:
            ▪︎ trong dãy số tối đa 1 số xuất hiện lẻ lần.
            ▪︎ tất cả số xuất hiện chẵn

        time O(n)
        space O(h)
            ▪︎ balanced tree: O(logn)
            ▪︎ skew tree: O(n)
     */
    public int pseudoPalindromicPaths(TreeNode root) {
        int[] freq = new int[10];
        return dfs(root, freq);
    }

    public int dfs(TreeNode node, int[] freq) {
        if (node == null) {
            return 0;
        }

        freq[node.val]++;
        int count = 0;

        if (node.left == null && node.right == null) {
            if (isPseudo(freq)) {
                count = 1; // tìm thấy 1 nhánh hợp lệ khi đến node lá

                    }} else {
            count = dfs(node.left, freq) + dfs(node.right, freq);
        }

        // backtracking
        // đảm bảo mội node đều bị giảm
        freq[node.val]--;

        return count;
    }

    public boolean isPseudo(int[] freq) {
        int odd = 0;
        for (int f : freq) {
            if (f % 2 == 1) {
                odd++;
            }
        }

        return odd <= 1;
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

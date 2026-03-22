
@SuppressWarnings("unused")
class ConvertSortedArrayToBinarySearchTree {

    /*
        time O(n)
        space O(h)
            ▪︎ balanced tree: h = logn
            ▪︎ skew tree: h = On
    
     */
    int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        this.nums = nums;
        return dfs(0, nums.length - 1);
    }

    public TreeNode dfs(int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(l, mid - 1);
        root.right = dfs(mid + 1, r);

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

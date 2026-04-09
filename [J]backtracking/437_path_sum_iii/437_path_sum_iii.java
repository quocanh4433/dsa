
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
class PathSumIII {

    /*
        this problem same 560 sum subarray equal k

        time O(n) 
        space O(h) ~ worst case: O(n)

        có sự khác giữa truyền currentSum và hàm dfs và curentSum global
     */
    Map<Long, Integer> prefix; // key: currentSum - value: frequency of curretnSum
    long currentSum = 0;
    int target;

    public int pathSum(TreeNode root, int targetSum) {
        prefix = new HashMap<>();
        prefix.put(0L, 1);
        target = targetSum;
        return dfs(root);
    }

    public int dfs(TreeNode node) {

        if (node == null) {
            return 0;
        }

        currentSum += node.val;

        int count = prefix.getOrDefault(currentSum - target, 0);
        prefix.put(currentSum, prefix.getOrDefault(currentSum, 0) + 1);

        count += dfs(node.left);
        count += dfs(node.right);

        // backtracking: 
        prefix.put(currentSum, prefix.get(currentSum) - 1);
        currentSum -= node.val;

        return count;
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


import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("unused")
class SumRootToLeafNumbers {

    /*
        time O(n * h) vì
            duyệt qua tưng node O(n)
            đi đến leaf duyệt mảng nums tốn O(h)

            nếu cây cân băng time O(n logn)
            nếu cây nghiên time O(n**2)

        space O(h) recursion
     */
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, new ArrayList<>());
        return sum;
    }

    public void dfs(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }

        nums.add(root.val);

        if (root.left == null && root.right == null) {
            int res = 0;
            for (int num : nums) {
                res = res * 10 + num;
            }
            sum += res;
        }

        dfs(root.left, nums);
        dfs(root.right, nums);

        nums.remove(nums.size() - 1);
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

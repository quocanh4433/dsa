
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
class PathSumII {

    /*
        time 
            - mỗi node duyệt 1 lần O(n)
            - mỗi path hợp lên res.add(new ArrayList<>(path)) tốn O(h)
        
        nếu cây cần băng h = logn -> time: O(n logn)
        nếu cây nghiên h = n -> time O(n) không phải n * n
        

        space O(n * h)
     */

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, new ArrayList<>());
        return res;
    }

    public void dfs(TreeNode root, int targetSum, List<Integer> path) {
        if (root == null) {
            return;
        }

        int remain = targetSum - root.val;

        path.add(root.val);

        if (remain == 0 && isLeaf(root)) {
            res.add(new ArrayList<>(path));
        }

        dfs(root.left, remain, path);
        dfs(root.right, remain, path);

        // backtracking
        path.remove(path.size() - 1);

    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
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

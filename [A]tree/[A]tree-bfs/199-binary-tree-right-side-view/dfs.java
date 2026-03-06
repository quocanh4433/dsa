
import java.util.*;

class Solution {

    /*
        time O(n)
        space O(h) - h: height of tree
            ▪︎ balanced tree: O(logn)
            ▪︎ skewed tree: O(n)
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, res, 0);
        return res ;
    }
    /*
        ▪︎ level: cho biết level của node
        ▪︎ res.size(): cho biết level nào chưa có node

        node ở đúng level chưa có node nào -> level == res.size()

        val của node đó chính là giá trị cần tìm
        
    */
    private void dfs(TreeNode node, List<Integer> res, int level) {
        if (node == null) {
            return;
        }

        if (level == res.size()) {
            res.add(node.val);
        }

        dfs(node.right, res, level + 1);
        dfs(node.left, res, level + 1);
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

}

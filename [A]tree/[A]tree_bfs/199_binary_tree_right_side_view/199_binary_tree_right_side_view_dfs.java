
import java.util.*;

@SuppressWarnings("unused")
class BinaryTreeRightSideView_DFS {

    /*
        time O(n)
        space O(h)
            ▪︎ balanced tree: h = O(logn)
            ▪︎ skewed tree: h = O(n)

        idea
            ▪︎ level: cho biết level của node
            ▪︎ res.size(): cho biết level nào chưa có node bên phải
                ▪︎ res.size() = 1 tức level 1 chưa có node right nào
            ▪︎ node right cần tìm ở đúng level chưa có node nào -> level == res.size()

        dry run

           1
         /   \
        2     3


        1/
            res.size = 0
            level = 0
            node = 1
            -> res.size == level ->  res = {1}  

        2/ đi right trước
            res.size = 1
            level = 1
            node = 3
            -> res.size == level -> res = {1, 3}

        3/ đi left
            res.size = 2
            level = 1
            node = 2
            -> đang ở level 1 nhưng level 1 đã kết quả -> return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, res, 0);
        return res ;
    }
  
    private void dfs(TreeNode node, List<Integer> res, int level) {
        if (node == null) {
            return;
        }

        if (level == res.size()) {
            res.add(node.val);
        }
        
        // đi right trước
        dfs(node.right, res, level + 1);
        dfs(node.left, res, level + 1);
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

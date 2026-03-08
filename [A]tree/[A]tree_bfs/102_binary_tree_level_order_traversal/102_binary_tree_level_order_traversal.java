import java.util.*;

@SuppressWarnings("unused")
class BinaryTreeLevelOrderTraversal {
    /*
        time O(n)
        space O(w) ~ O(n)
    */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<List<Integer>> res = new ArrayList<>();

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();

                if (cur != null) {
                    temp.add(cur.val);
                    if (cur.left != null) {
                        q.offer(cur.left);
                    }
                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                }
            }

            if (!temp.isEmpty()) {
                res.add(temp);
            }
        }

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

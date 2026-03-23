
import java.util.*;

@SuppressWarnings("unused")
class BinaryTreeRightSideView_BFS {

    /*
        time O(n)
        space O(w) - w: width of tree

        ý tưởng


     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();

                if (i == 0) {
                    // i = 0 chính là node right được push vào
                    res.add(cur.val);
                }

                // node right phải được đưa vào queue trước
                if (cur.right != null) {
                    q.offer(cur.right);
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }

                /*
                    OR
                    if(i == size - 1) res.add(cur.val);
                    if(cur.left != null) q.offer(cur.left);
                    if(cur.right != null) q.offer(cur.right);
                    
                 */
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

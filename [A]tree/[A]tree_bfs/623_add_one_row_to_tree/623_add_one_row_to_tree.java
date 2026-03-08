
import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unused")
class AddOneRowToTree {
    /*
        time O(n)
        space O(w) or O(n)
            ▪︎ w: width of tree 
            ▪︎ last level perfetch binary tree w ≈ 2^(h-1) ≈ n/2 ≈ n
    */
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            
            // 💡 [QUAN TRỌNG]
            // thay đổi tại depth nhưng điểm kết nối với root là tại depth - 1
            if (level == depth - 1) { 
                for (int i = 0; i < size; i++) {
                    TreeNode cur = q.poll();
                    TreeNode nodeLeft = cur.left;
                    TreeNode nodeRight = cur.right;

                    cur.left = new TreeNode(val);
                    cur.left.left = nodeLeft;

                    cur.right = new TreeNode(val);
                    cur.right.right = nodeRight;
                }
                break;
            }

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            level++;
        }

        return root;
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

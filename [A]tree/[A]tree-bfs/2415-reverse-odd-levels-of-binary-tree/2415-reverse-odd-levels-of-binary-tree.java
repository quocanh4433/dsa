import java.util.*;

@SuppressWarnings("unused")
class ReverseOddLevelsOfBinaryTree {
    /*
        time O(n)
        space O(w) or O(n)
            - w: width of tree 
            - last level w ≈ 2^(h-1) ≈ n/2 ≈ n
    */
    public TreeNode reverseOddLevels(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            List<TreeNode> nodes = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                nodes.add(cur);
                
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }

            if (level % 2 != 0) {
                int l = 0;
                int r = nodes.size() - 1;

                while (l < r) {
                    int temp = nodes.get(l).val;
                    nodes.get(l).val = nodes.get(r).val;
                    nodes.get(r).val = temp;
                    l++;
                    r--;
                }
            }

            level++;
        }

        return root;
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

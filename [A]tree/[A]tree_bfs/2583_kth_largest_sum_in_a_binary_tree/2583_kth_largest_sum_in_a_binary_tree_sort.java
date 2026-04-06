import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("unused")
class KthLargestSumInABinaryTree_Sort {

    /*
        time O(n long n)
            ▪︎ bfs O(n)
            ▪︎ sort O(nlogn)
        space O(n) 
    */
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Long> list = new ArrayList<>();

        while (!q.isEmpty()) {
            int size = q.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                sum += cur.val;
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            list.add(sum);
        }

        Collections.sort(list); // O(nlogn) skewed tree

        if (k > list.size()) {
            return -1;
        }
        return list.get(list.size() - k);
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

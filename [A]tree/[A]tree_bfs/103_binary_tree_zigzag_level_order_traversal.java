
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    /*
        time: O(n)
        space: O(n)

        idea:
        each odd row is reversed
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    continue;
                }
                temp.add(cur.val);
                
                // add element into queue from left to right
                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }


            if (!leftToRight) {
                Collections.reverse(temp);
            }

            if (!temp.isEmpty()) {
                res.add(temp);
            }
            leftToRight = !leftToRight;
        }
        return res;
    }

}

class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return toStringHelper(this);
    }

    private String toStringHelper(TreeNode node) {
        if (node == null) {
            return "N";
        }
        return node.val + "(" + toStringHelper(node.left) + "," + toStringHelper(node.right) + ")";
    }
}

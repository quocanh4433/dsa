
import java.util.*;

@SuppressWarnings("unused")
class AmountOfTimeForBinaryTreeToBeInfected {
    /*
        time O(n)
        space O(n)    
    */
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>(); // key: childNode - value: parentNode
        TreeNode startNode = buildParent(root, parentMap, start);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.offer(startNode);
        visited.add(startNode);

        // why not time = 0?
        int time = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            time++;

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();

                if (cur.left != null && !visited.contains(cur.left)) {
                    q.offer(cur.left);
                    visited.add(cur.left);
                }

                if (cur.right != null && !visited.contains(cur.right)) {
                    q.offer(cur.right);
                    visited.add(cur.right);
                }

                TreeNode parent = parentMap.get(cur);
                if (parent != null && !visited.contains(parent)) {
                    q.offer(parent);
                    visited.add(parent);
                }
            }
        }

        return time;

    }

    private TreeNode buildParent(TreeNode node, Map<TreeNode, TreeNode> parentMap, int start) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);

        TreeNode startNode = null;

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();

            if (cur.val == start) {
                startNode = cur;
            }

            if (cur.left != null) {
                q.offer(cur.left);
                parentMap.put(cur.left, cur);
            }

            if (cur.right != null) {
                q.offer(cur.right);
                parentMap.put(cur.right, cur);
            }

        }

        return startNode;
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

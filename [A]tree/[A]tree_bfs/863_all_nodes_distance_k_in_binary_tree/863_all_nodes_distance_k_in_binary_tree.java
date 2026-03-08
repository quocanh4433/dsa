
import java.util.*;

@SuppressWarnings("unused")
class AllNodesDistanceKInBinaryTree {

    /*
        time O(n)
        space O(n)    
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>(); // key: childNode - value: parentNode
        buildGraph(root, null, parentMap);

        List<Integer> res = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();

        visited.add(target);
        q.offer(target);

        int distance = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            if (distance == k) {
                for (TreeNode node : q) {
                    res.add(node.val);
                }
                break;
            }

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

                TreeNode p = parentMap.get(cur);
                if (p != null && !visited.contains(p)) {
                    q.offer(p);
                    visited.add(p);
                }

            }

            distance++; // increasing distance prepare for the next loop;

        }
        return res;
    }

    private void buildGraph(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (node == null) {
            return;
        }

        buildGraph(node.left, node, parentMap);
        buildGraph(node.right, node, parentMap);
        parentMap.put(node, parent);
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
